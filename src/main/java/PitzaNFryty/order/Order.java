package PitzaNFryty.order;

import PitzaNFryty.address.Address;
import PitzaNFryty.customer.Customer;
import PitzaNFryty.menu_item.MenuItem;
import PitzaNFryty.payment.Payment;
import com.sun.istack.NotNull;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    private Long id;

    @ManyToOne(targetEntity = Customer.class, cascade = CascadeType.MERGE)
    @LazyToOne(LazyToOneOption.NO_PROXY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(targetEntity = Address.class, cascade = CascadeType.MERGE)
    @LazyToOne(LazyToOneOption.NO_PROXY)
    @JoinColumn(name = "address_id")
    private Address address;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(targetEntity = MenuItem.class, cascade = CascadeType.MERGE)
    @JoinTable(name = "orders_menu_items",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "menu_item_id")})
    private List<? extends MenuItem> menuItems;

    @NotNull
    @OneToOne(targetEntity = Payment.class, cascade = CascadeType.PERSIST)
    @LazyToOne(LazyToOneOption.NO_PROXY)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @NotNull
    @Column(name = "creation_time")
    private LocalDateTime creationTime;

    public Order(Customer customer, Address address, List<MenuItem> menuItems, Payment payment, LocalDateTime creationTime) {
        this.customer = customer;
        this.address = address;
        this.menuItems = menuItems;
        this.payment = payment;
        this.creationTime = creationTime;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setCustomer(Customer customer, boolean add) {
        this.customer = customer;
        if(customer != null && add) {
            customer.addOrder(this, false);
        }
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<? extends MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<? extends MenuItem> menuItems) {
        this.menuItems = menuItems;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[")
                .append(this.customer.getFirstName()).append(" ").append(this.customer.getLastName()).append(", ")
                .append(this.address.getStreet()).append(this.address.getBuildingNumber()).append(", ");
        sb.append("{");
        menuItems.forEach(menuItem -> {
            sb.append(menuItem.toString()).append(", ");
        });
        sb.append("}");
        sb.append(this.payment.toString())
        .append(this.creationTime).append("]");
        return sb.toString();
    }
}
