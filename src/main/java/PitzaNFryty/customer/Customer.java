package PitzaNFryty.customer;

import PitzaNFryty.address.Address;
import PitzaNFryty.order.Order;
import com.sun.istack.NotNull;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    private long id;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "phone_number")
    private int phoneNumber;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity = Address.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "customers_addresses",
            joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "address_id")})
    private List<Address> addresses;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity = Order.class, mappedBy = "customer", cascade = CascadeType.PERSIST)
    private List<Order> orders;

    public Customer(String firstName, String lastName, int phoneNumber, List<Address> addresses, List<Order> orders) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.addresses = addresses;
        this.orders = orders;
    }

    public Customer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.firstName).append(", ")
                .append(this.lastName).append(", ")
                .append(this.phoneNumber).append(", ");
        this.addresses.forEach(address -> sb.append(address.toString()));
        this.orders.forEach(order -> sb.append(order.toString()));
        return sb.toString();
    }
}
