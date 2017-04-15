package dao;
import connection.ConnectionManager;
import entity.Groups;
import entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Dzianis on 09.04.2017.
 */
public class PersonDao {
    private static final Object LOCK = new Object();
    private static PersonDao INSTANCE = null;

    public static PersonDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new PersonDao();
                }
            }
        }
        return INSTANCE;
    }

    public static boolean delete(long id) {
        try(Connection connection = ConnectionManager.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT id FROM customer_order WHERE person_id = ?")) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return false;
                }
            }
            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM person WHERE id = ?")) {
                preparedStatement.setLong(1, id);
                preparedStatement.executeUpdate();
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static Optional<Person> getById(long id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT p.id, first_name, lastName, email, password, address, phone, groups_name " +
                         "FROM person AS p JOIN groups AS g ON p.groups_id = g.id " +
                          "WHERE p.id = ?")) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return Optional.of(creatPerson(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private static Person creatPerson(ResultSet resultSet){
        try {
            return new Person(resultSet.getLong("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("lastName"),
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    resultSet.getString("address"),
                    resultSet.getString("phone"),
                    Groups.valueOf(resultSet.getString("groups_name")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return null;
    }

    public static Optional<Person> save(Person person) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO person (first_name, lastName, email, password, " +
                            "address, phone, groups_id) VALUES (?, ?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, person.getFirstName());
                preparedStatement.setString(2, person.getLastName());
                preparedStatement.setString(3, person.getEmail());
                preparedStatement.setString(4, person.getPassword());
                preparedStatement.setString(5, person.getAddress());
                preparedStatement.setString(6, person.getPhone());
                preparedStatement.setInt(7, 1);
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    person.setId(generatedKeys.getLong(1));
                    return Optional.of(person);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static Optional<List<Person>> getAll() {
        List<Person> list = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    " SELECT p.id, first_name, lastName, email, password, address, " +
                            "phone, groups_name FROM person AS p JOIN groups AS g ON " +
                            "p.groups_id = g.id")) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        list.add(creatPerson(resultSet));
                    }
                }
                return Optional.of(list);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}


