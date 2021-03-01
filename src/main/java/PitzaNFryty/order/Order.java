package PitzaNFryty.order;

import PitzaNFryty.address.Address;
import PitzaNFryty.customer.Customer;
import PitzaNFryty.menu_item.MenuItem;
import PitzaNFryty.payment.Payment;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Address address;

    @OneToMany(targetEntity = MenuItem.class)
    @JoinTable(name = "users_orders")
    //private List<? extends MenuItem> products;
    private List<MenuItem> products;

    @OneToOne
    private Payment payment;

    @NotNull
    @Column(name = "creation_time")
    private LocalDateTime creationTime;

    @NotNull
    @Column(name = "delivery_time")
    private LocalDateTime deliveryTime;

    public Order(Customer customer, Address address, List<MenuItem> products, Payment payment, LocalDateTime creationTime, LocalDateTime deliveryTime) {
        this.customer = customer;
        this.address = address;
        this.products = products;
        this.payment = payment;
        this.creationTime = creationTime;
        this.deliveryTime = deliveryTime;
    }

    public Order() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<MenuItem> getProducts() {
        return products;
    }

    public void setProducts(List<MenuItem> products) {
        this.products = products;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
}
