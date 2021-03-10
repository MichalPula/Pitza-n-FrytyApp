package PitzaNFryty.address;


import PitzaNFryty.customer.Customer;
import com.sun.istack.NotNull;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    private long id;

    @ManyToOne(targetEntity = Customer.class)
    @LazyToOne(LazyToOneOption.NO_PROXY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @NotNull
    @Column(name = "city")
    private String city;

    @NotNull
    @Column(name = "zip_code")
    private String zipCode;

    @NotNull
    @Column(name = "street")
    private String street;

    @NotNull
    @Column(name = "building_number")
    private String buildingNumber;

    @NotNull
    @Column(name = "flat_number")
    private String flatNumber;

    public Address(Customer customer, String city, String zipCode, String street, String buildingNumber, String flatNumber) {
        this.customer = customer;
        this.city = city;
        this.zipCode = zipCode;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.flatNumber = flatNumber;
    }

    public Address(String city, String zipCode, String street, String buildingNumber, String flatNumber) {
        this.city = city;
        this.zipCode = zipCode;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.flatNumber = flatNumber;
    }

    public Address() {

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[")
                .append(this.city).append(", ")
                .append(this.zipCode).append(", ")
                .append(this.street).append(", ")
                .append(this.buildingNumber).append(", ")
                .append(this.flatNumber).append("]");
        return sb.toString();
    }
}
