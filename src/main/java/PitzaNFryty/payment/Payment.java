package PitzaNFryty.payment;

import PitzaNFryty.customer.Customer;
import com.sun.istack.NotNull;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    private Long id;

    @ManyToOne(targetEntity = Customer.class, cascade = CascadeType.MERGE)
    @LazyToOne(LazyToOneOption.NO_PROXY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @NotNull
    @Column(name = "price")
    private BigDecimal moneyAmount;

    @NotNull
    @Column(name = "time")
    private LocalDateTime time;

    public Payment(Customer customer, BigDecimal moneyAmount, LocalDateTime time) {
        this.customer = customer;
        this.moneyAmount = moneyAmount;
        this.time = time;
    }

    public Payment() {

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

    public BigDecimal getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(BigDecimal moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return this.id + " {" +this.customer.getFirstName() + " " + this.customer.getLastName()
                + this.moneyAmount + "}";
    }
}
