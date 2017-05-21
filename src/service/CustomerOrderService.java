package service;

import dao.CustomerOrderDao;
import entity.CustomerOrder;
import entity.OrderStatus;
import entity.Product;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Dzianis on 13.04.2017.
 */
public class CustomerOrderService {
    private static final Object LOCK = new Object();
    private static CustomerOrderService INSTANCE = null;

    public static CustomerOrderService getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new CustomerOrderService();
                }
            }
        }
        return INSTANCE;
    }

    public static boolean changeStatus(Long orderId, OrderStatus orderStatus) {
        return CustomerOrderDao.getInstance().changeStatus(orderId, orderStatus);
    }

    public static boolean deleteBeforeDate(LocalDate date) {
        return CustomerOrderDao.getInstance().deleteBeforeDate(date);
    }

    public static boolean deleteProduct(Long orderId, Long productId) {
        return CustomerOrderDao.getInstance().deleteProduct(orderId, productId);
    }

    public static boolean delete(long id) {
        return CustomerOrderDao.getInstance().delete(id);
    }

    public static Optional<CustomerOrder> save(CustomerOrder customerorder) {
        Optional<CustomerOrder> fullInfo = CustomerOrderDao.getInstance().save(customerorder);
        if (fullInfo.isPresent()) {
            return fullInfo;
        }
        return Optional.empty();
    }

    public static Optional<CustomerOrder> getById(Long id) {
        Optional<CustomerOrder> fullInfo = CustomerOrderDao.getInstance().getById(id);
        if (fullInfo.isPresent()) {
            return fullInfo;
        }
        return Optional.empty();
    }

    public static List getAllCustomerOrders(Long id) {
        return CustomerOrderDao.getInstance().getAllCustomerOrders(id);

    }

    public static List showForPeriod(LocalDate startDate, LocalDate finalDate) {
        return CustomerOrderDao.getInstance().showForPeriod(startDate, finalDate);

    }

    public static List getAllOrdersProduct(Long id) {
        return CustomerOrderDao.getInstance().getAllOrdersProduct(id);
    }

    public static List getAllOrders() {
        return CustomerOrderDao.getInstance().getAllOrders();
    }

    public static Optional<CustomerOrder> catr(Long id) {
        List<CustomerOrder> list = CustomerOrderService.getInstance().getAllCustomerOrders(id);
        Optional<CustomerOrder> cart = list.stream().filter(o -> o.getOrderStatus() == OrderStatus.CREATED).findFirst();
        return cart;
    }

    public static String createReport(Long id) {
        StringBuffer report = new StringBuffer("");
        Optional<CustomerOrder> fullInfo = CustomerOrderDao.getInstance().getById(id);
        if (fullInfo.isPresent()) {
            CustomerOrder order = fullInfo.get();
            report.append("Интернет-магазин: ЗАО «Витэкс» и СП «Белита» ООО"+
                    "\nЗаказ №" + order.getId() +
                    "\nЗаказчик: " + order.getPerson().getName() +
                    "\nДата: " + order.getDateCreated() +
                    "\nТовары в заказе:\n");
            for (Map.Entry<Product, Integer> entry : order.getOrderItem().entrySet()) {
                report.append("Название: " + entry.getKey().getProductName()
                        + ". Количество: " + entry.getValue() +" шт. "
                        + "Цена за шт.: " + entry.getKey().getPrice() + " рублей.\n");
            }
            report.append("Итого: " +order.orderPrice() + " рублей.\n");
        }
        return report.toString();
    }
}
