package service;

import dao.CategoryDao;
import dao.CategoryDao;
import entity.Category;

import java.util.List;
import java.util.Optional;

/**
 * Created by Dzianis on 13.04.2017.
 */
public class CategoryService {
    private static final Object LOCK = new Object();
    private static CategoryService INSTANCE = null;

    public static CategoryService getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new CategoryService();
                }
            }
        }
        return INSTANCE;
    }

    public static boolean delete(long id) {
        return CategoryDao.getInstance().delete(id);
    }

    public static Optional<Category> save(Category category) {
        Optional<Category> fullInfo = CategoryDao.getInstance().save(category);
        if (fullInfo.isPresent()) {
            return fullInfo;
        }
        return Optional.empty();
    }

    public static Optional<Category> getById(long id) {
        Optional<Category> fullInfo = CategoryDao.getInstance().getById(id);
        if (fullInfo.isPresent()) {
            return fullInfo;
        }
        return Optional.empty();
    }

    public static Optional<List<Category>> getAll() {
        Optional<List<Category>> fullInfo = CategoryDao.getInstance().getAll();
        if (fullInfo.isPresent()) {
            return fullInfo;
        }
        return Optional.empty();
    }
}
