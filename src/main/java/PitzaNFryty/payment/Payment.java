package PitzaNFryty.payment;

import PitzaNFryty.customer.Customer;
import com.sun.istack.NotNull;

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
