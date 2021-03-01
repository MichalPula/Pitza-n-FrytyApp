package PitzaNFryty.payment;

import PitzaNFryty.customer.Customer;
import com.sun.istack.NotNull;
import org.joda.money.Money;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(targetEntity = Customer.class)
    private Customer customer;

    @NotNull
    @Column(name = "money")
    private Money money;

    @NotNull
    private LocalDateTime time;

    public Payment(Customer customer, Money money, LocalDateTime time) {
        this.customer = customer;
        this.money = money;
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

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
