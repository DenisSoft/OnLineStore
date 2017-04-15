package service;

import dao.CustomerOrderDao;
import entity.CustomerOrder;

import java.time.LocalDate;
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

    public static boolean deleteBeforeDate(LocalDate date) {
        return CustomerOrderDao.getInstance().deleteBeforeDate(date);
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

    public static Optional getAllCustomerOrders(Long id) {
        Optional<CustomerOrder> fullInfo = CustomerOrderDao.getInstance().getAllCustomerOrders(id);
        if (fullInfo.isPresent()) {
            return fullInfo;
        }
        return Optional.empty();
    }

    public static Optional getAllOrdersProduct(Long id) {
        Optional<CustomerOrder> fullInfo = CustomerOrderDao.getInstance().getAllOrdersProduct(id);
        if (fullInfo.isPresent()) {
            return fullInfo;
        }
        return Optional.empty();
    }
}
