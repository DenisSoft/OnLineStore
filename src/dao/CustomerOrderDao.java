package dao;
import connection.ConnectionManager;
import entity.CustomerOrder;
import entity.OrderStatus;
import entity.Person;
import entity.Product;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

/**
 * Created by Dzianis on 10.04.2017.
 */
public class CustomerOrderDao {

    private static final Object LOCK = new Object();
    private static dao.CustomerOrderDao INSTANCE = null;

    public static dao.CustomerOrderDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new dao.CustomerOrderDao();
                }
            }
        }
        return INSTANCE;
    }

    public static boolean deleteBeforeDate(LocalDate date) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE c, o FROM customer_order AS c LEFT JOIN orderitem AS o " +
                            "ON customer_order_id = c.id WHERE date_created <= ? " +
                            "AND orderstatus_id > 1")) {
                preparedStatement.setDate(1, Date.valueOf(date));
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean changeStatus(Long orderId, OrderStatus orderStatus) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE customer_order\n " +
                            "SET orderstatus_id = ?, date_closing = NOW() " +
                            "WHERE customer_order.id = ?;")) {
                preparedStatement.setLong(1, (orderStatus.ordinal()+1));
                preparedStatement.setLong(2, orderId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean delete(long id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE customer_order, orderitem FROM customer_order LEFT JOIN orderitem " +
                            "ON customer_order_id = customer_order.id WHERE customer_order.id = ?")) {
                preparedStatement.setLong(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static Optional<CustomerOrder> save(CustomerOrder customerorder) {
        try (Connection connection = ConnectionManager.getConnection()) {
            connection.setAutoCommit(false);
            Map<Product, Integer> orderItem = customerorder.getOrderItem();
            Map<Long, Integer> residue = new HashMap<>();
            long productId;
            int quantity;
            for (Map.Entry<Product, Integer> entry : orderItem.entrySet()) {
                productId = entry.getKey().getId();
                quantity = entry.getValue();
                try (PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT residue FROM product WHERE product.id = ?")) {
                    preparedStatement.setLong(1, productId);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        residue.put(productId, resultSet.getInt("residue"));
                        int residueProduct = residue.get(productId);
                        if (residueProduct < quantity) {
                                String errorDescription = "К сожалению товара "
                                        +entry.getKey().getProductName() +" нет в количестве " +quantity
                                        +" шт. его осталось " +residueProduct +" шт.";
                                customerorder.setErrors(errorDescription);
                                return Optional.of(customerorder);
                        }
                    } else {
                        return Optional.empty();
                    }
                }
            }
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO customer_order (person_id, date_created, orderstatus_id)" +
                            "VALUES (?, NOW(),  1)",
                    Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setLong(1, customerorder.getPerson().getId());
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    customerorder.setId(generatedKeys.getLong(1));
                }
            }
            for (Map.Entry<Product, Integer> entry : orderItem.entrySet()) {
                productId = entry.getKey().getId();
                quantity = entry.getValue();
                try (PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO orderitem (customer_order_id,  product_id, quantity)" +
                                "VALUES (?, ?, ?)")) {
                    preparedStatement.setLong(1, customerorder.getId());
                    preparedStatement.setLong(2, productId);
                    preparedStatement.setInt(3, quantity);
                    preparedStatement.executeUpdate();
                }
                try (PreparedStatement preparedStatement = connection.prepareStatement(
                        "UPDATE product SET residue = ? WHERE id = ?")) {
                    preparedStatement.setInt(1, (residue.get(productId) - quantity));
                    preparedStatement.setLong(2, productId);
                    preparedStatement.executeUpdate();
                }
            }
            connection.commit();
            return Optional.of(customerorder);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static List getAllCustomerOrders(Long id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT c.id, person_id, product_id, product_name, price, quantity, date_created," +
                            " date_closing, status FROM product AS p JOIN orderitem AS o ON p.id = " +
                            "o.product_id JOIN customer_order AS c ON c.id = o.customer_order_id " +
                            "JOIN orderstatus ON orderstatus.id = c.orderstatus_id " +
                            "WHERE person_id = ?")) {
                preparedStatement.setLong(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return creatingOrderList(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList();
    }

    private static LocalDate dateClosing(Date date) {
        return date == null ? null : date.toLocalDate();
    }

    public static List getAllOrdersProduct(Long id) {
        List<CustomerOrder> listOrders = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT cu.id, person_id, date_created, date_closing, status " +
                            "FROM customer_order AS cu " +
                            "JOIN orderitem AS o ON  o.customer_order_id = cu.id " +
                            "JOIN orderstatus AS st ON cu.orderstatus_id = st.id " +
                            "WHERE o.product_id = ?")) {
                preparedStatement.setLong(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        CustomerOrder order = new CustomerOrder(
                                resultSet.getLong("id"),
                                new Person(resultSet.getLong("person_id")),
                                resultSet.getDate("date_created").toLocalDate(),
                                dateClosing(resultSet.getDate("date_closing")),
                                OrderStatus.valueOf(resultSet.getString("status")));
                        listOrders.add(order);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOrders;
    }

    public static List getAllOrders() {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT c.id, person_id, product_id, product_name, price, quantity, date_created, " +
                            "date_closing, status FROM product AS p JOIN orderitem AS o ON p.id = " +
                            "o.product_id JOIN customer_order AS c ON c.id = o.customer_order_id " +
                            "JOIN orderstatus ON orderstatus.id = c.orderstatus_id;")) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return creatingOrderList(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList();
    }

    private static List creatingOrderList(ResultSet resultSet) throws SQLException {
        Map<Long, CustomerOrder> listAllCustomerOrders = new HashMap<>();
        while (resultSet.next()) {
            long customerOrderId = resultSet.getLong("id");
            Product nextProduct = new Product(resultSet.getLong("product_id"),
                    resultSet.getString("product_name"),
                    resultSet.getInt("price"));
            Integer quantity = resultSet.getInt("quantity");
            if (listAllCustomerOrders.containsKey(customerOrderId)) {
                listAllCustomerOrders.get(customerOrderId).getOrderItem()
                        .put(nextProduct, quantity);
            } else {
                listAllCustomerOrders.put(customerOrderId, new CustomerOrder
                        (customerOrderId, new Person(resultSet.getLong("person_id")),
                                new HashMap<Product, Integer>() {{
                                    put(nextProduct, quantity);
                                }},
                                resultSet.getDate("date_created").toLocalDate(),
                                dateClosing(resultSet.getDate("date_closing")),
                                OrderStatus.valueOf(resultSet.getString("status"))));
            }
        }
        return new ArrayList<>(listAllCustomerOrders.values());
    }

    public static boolean deleteProduct(Long orderId, Long productId) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM orderitem WHERE customer_order_id = ? AND product_id = ?")) {
                preparedStatement.setInt(1, Math.toIntExact(orderId));
                preparedStatement.setInt(2, Math.toIntExact(productId));
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static Optional<CustomerOrder> getById(Long id) {
        CustomerOrder order = null;
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT person_id, first_name, lastName, product_id, product_name, quantity, " +
                            "price, date_created, date_closing, status " +
                            "FROM product AS p JOIN orderitem AS o ON p.id = o.product_id " +
                            "JOIN customer_order AS c ON c.id = o.customer_order_id " +
                            "JOIN person ON c.person_id = person.id  " +
                            "JOIN orderstatus ON orderstatus.id = c.orderstatus_id WHERE c.id = ?")) {
                preparedStatement.setLong(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Product nextProduct = new Product(resultSet.getLong("product_id"),
                                resultSet.getString("product_name"),
                                resultSet.getInt("price"));
                        Integer quantity = resultSet.getInt("quantity");
                        if(order == null){
                            Map<Product, Integer> orderItem = new HashMap<Product, Integer>() {{
                                put(nextProduct, quantity);
                            }};
                            order = new CustomerOrder( id,
                                    new Person(resultSet.getLong("person_id"),
                                    resultSet.getString("first_name"),
                                    resultSet.getString("lastName")),
                                    orderItem,
                                    resultSet.getDate("date_created").toLocalDate(),
                                    dateClosing(resultSet.getDate("date_closing")),
                                    OrderStatus.valueOf(resultSet.getString("status")));
                        }else{
                            order.getOrderItem().put(nextProduct, quantity);

                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(order);
    }

    public static List showForPeriod(LocalDate startDate, LocalDate finalDate) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT c.id, person_id, product_id, product_name, price, quantity, date_created, " +
                            "date_closing, status FROM product AS p JOIN orderitem AS o ON p.id = o.product_id " +
                            "JOIN customer_order AS c ON c.id = o.customer_order_id " +
                            "JOIN orderstatus ON orderstatus.id = c.orderstatus_id " +
                            "WHERE date_created >= ? AND date_created <= ?")) {
                preparedStatement.setDate(1, Date.valueOf(startDate));
                preparedStatement.setDate(2, Date.valueOf(finalDate));
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return creatingOrderList(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList();
    }
}


