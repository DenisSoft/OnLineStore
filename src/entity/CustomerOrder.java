package entity;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dzianis on 28.03.2017.
 */
public class CustomerOrder extends BaseEntity{
    private Person person;
    private Map<Product, Integer> orderItem;
    private LocalDate dateCreated;
    private LocalDate dateClosing;
    private OrderStatus orderStatus;
    private String errors;

    public CustomerOrder(Person person) {
        this.person = person;
        this.orderItem = new HashMap<Product, Integer>();
    }

    public CustomerOrder(long id, Person person, Map<Product, Integer> orderItem) {
        super(id);
        this.person = person;
        this.orderItem = orderItem;
    }

    public CustomerOrder(long id, Person person, Map<Product, Integer> orderItem, LocalDate dateCreated, OrderStatus orderStatus) {
        super(id);
        this.person = person;
        this.orderItem = orderItem;
        this.dateCreated = dateCreated;
        this.orderStatus = orderStatus;
    }

    public CustomerOrder(long id, Person person, LocalDate dateCreated, LocalDate dateClosing, OrderStatus orderStatus) {
        super(id);
        this.person = person;
        this.dateCreated = dateCreated;
        this.dateClosing = dateClosing;
        this.orderStatus = orderStatus;
    }

    public CustomerOrder(long id, Person person, Map<Product, Integer> orderItem, LocalDate dateCreated, LocalDate dateClosing, OrderStatus orderStatus) {
        super(id);
        this.person = person;
        this.orderItem = orderItem;
        this.dateCreated = dateCreated;
        this.dateClosing = dateClosing;
        this.orderStatus = orderStatus;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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

    public long orderPrice(){
        long number = 0;
        for (Map.Entry<Product, Integer> entry : orderItem.entrySet()) {
            number += entry.getKey().getPrice() * entry.getValue();
        }
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerOrder customerOrder = (CustomerOrder) o;

        return getId() == customerOrder.getId();
    }

    @Override
    public int hashCode() {
        return (int) (getId() ^ (getId() >>> 32));
    }

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "person=" + person +
                ", orderItem=" + orderItem +
                ", dateCreated=" + dateCreated +
                ", dateClosing=" + dateClosing +
                ", orderStatus=" + orderStatus +
                ", errors='" + errors + '\'' +
                '}';
    }
}

