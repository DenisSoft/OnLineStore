package entity;

import java.time.LocalDate;
import java.util.Map;

/**
 * Created by Dzianis on 28.03.2017.
 */
public class CustomerOrder {
    private long id;
    private Long personId;
    private Map<Product, Integer> orderItem;
    private LocalDate dateCreated;
    private LocalDate dateClosing;
    private OrderStatus orderStatus;

    public CustomerOrder(long id, Long personId, Map<Product, Integer> orderItem) {
        this.id = id;
        this.personId = personId;
        this.orderItem = orderItem;
    }

    public CustomerOrder(long id, Long personId, Map<Product, Integer> orderItem, LocalDate dateCreated, OrderStatus orderStatus) {
        this.id = id;
        this.personId = personId;
        this.orderItem = orderItem;
        this.dateCreated = dateCreated;
        this.orderStatus = orderStatus;
    }

    public CustomerOrder(long id, Long personId, LocalDate dateCreated, LocalDate dateClosing, OrderStatus orderStatus) {
        this.id = id;
        this.personId = personId;
        this.dateCreated = dateCreated;
        this.dateClosing = dateClosing;
        this.orderStatus = orderStatus;
    }

    public CustomerOrder(long id, Long personId, Map<Product, Integer> orderItem, LocalDate dateCreated, LocalDate dateClosing, OrderStatus orderStatus) {
        this.id = id;
        this.personId = personId;
        this.orderItem = orderItem;
        this.dateCreated = dateCreated;
        this.dateClosing = dateClosing;
        this.orderStatus = orderStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Map<Product, Integer> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(Map<Product, Integer> orderItem) {
        this.orderItem = orderItem;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getDateClosing() {
        return dateClosing;
    }

    public void setDateClosing(LocalDate dateClosing) {
        this.dateClosing = dateClosing;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerOrder that = (CustomerOrder) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "id=" + id +
                ", personId=" + personId +
                ", orderItem=" + orderItem +
                ", dateCreated=" + dateCreated +
                ", dateClosing=" + dateClosing +
                ", orderStatus=" + orderStatus +
                '}';
    }
}

