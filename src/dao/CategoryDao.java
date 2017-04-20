package dao;

import connection.ConnectionManager;
import entity.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Dzianis on 08.04.2017.
 */
public class CategoryDao {
    private static final Object LOCK = new Object();
    private static CategoryDao INSTANCE = null;

    public static CategoryDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new CategoryDao();
                }
            }
        }
        return INSTANCE;
    }

    public static boolean delete(long id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT id FROM product WHERE category_id = ?")) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return false;
                }
            }
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM category WHERE id = ?")) {
                preparedStatement.setLong(1, id);
                preparedStatement.executeUpdate();
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static Optional<Category> save(Category category) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO category (category_name) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, category.getCategoryName());
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    category.setId(generatedKeys.getLong(1));
                    return Optional.of(category);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static Optional<Category> getById(long id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM category WHERE id = ?")) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return Optional.of(new Category(id, resultSet.getString("category_name")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static List<Category> getAll() {
        List<Category> list = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM category")) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        list.add(new Category(resultSet.getLong("id"),
                                resultSet.getString("category_name")));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
