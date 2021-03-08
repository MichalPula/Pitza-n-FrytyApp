package PitzaNFryty.customer;

import PitzaNFryty.address.Address;
import PitzaNFryty.order.Order;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    private Long id;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "phone_number")
    private int phoneNumber;

    @OneToMany(targetEntity = Address.class, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "customers_addresses",
            joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "address_id")})
    private Set<Address> addresses;

    @OneToMany(targetEntity = Order.class, mappedBy = "customer", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Order> orders;

    public Customer(String firstName, String lastName, int phoneNumber, Set<Address> addresses, Set<Order> orders) {
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

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {
        this.addOrder(order, true);
    }

    public void addOrder(Order order, boolean set) {
        if(order != null) {
            this.getOrders().add(order);
            if(set) {
                order.setCustomer(this, false);
            }
        }
    }

    public void deleteOrder(Order order) {
        this.getOrders().remove(order);
        order.setCustomer(null);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.firstName).append(" ")
                .append(this.lastName).append(", ")
                .append(this.phoneNumber).append(", ");
        this.addresses.forEach(address -> sb.append(address.toString()));
        this.orders.forEach(order -> sb.append(order.toString()));
        return sb.toString();
    }
}
