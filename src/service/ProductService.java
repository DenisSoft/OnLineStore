package service;

import dao.ProductDao;
import entity.Product;

import java.util.List;
import java.util.Optional;

/**
 * Created by Dzianis on 13.04.2017.
 */
public class ProductService {
    private static final Object LOCK = new Object();
    private static ProductService INSTANCE = null;

    public static ProductService getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new ProductService();
                }
            }
        }
        return INSTANCE;
    }

    public static boolean delete(long id) {
        return ProductDao.getInstance().delete(id);
    }

    public static Optional<Product> getById(long id) {
        Optional<Product> fullInfo = ProductDao.getInstance().getById(id);
        if (fullInfo.isPresent()) {
            return fullInfo;
        }
        return Optional.empty();
    }

    public static Optional<Product> save(Product product) {
        Optional<Product> fullInfo = ProductDao.getInstance().save(product);
        if (fullInfo.isPresent()) {
            return fullInfo;
        }
        return Optional.empty();
    }

    public List<Product> getAll() {
        return ProductDao.getInstance().getAll();
    }

    public List<Product> allProductByCategory(long id) {
        return ProductDao.getInstance().allProductByCategory(id);
    }
}
