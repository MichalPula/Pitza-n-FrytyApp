package PitzaNFryty.payment;

import PitzaNFryty.customer.Customer;
import PitzaNFryty.order.Order;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    private Long id;

    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @ToString.Exclude
    private Customer customer;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "order_id")
    @MapsId
    private Order order;

    @NotNull
    @Column(name = "money_amount")
    private BigDecimal moneyAmount;

    public Payment(Customer customer, Order order, BigDecimal moneyAmount) {
        this.customer = customer;
        this.order = order;
        this.moneyAmount = moneyAmount;
    }
}
