package PitzaNFryty.payment;

import PitzaNFryty.customer.User;
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

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @ToString.Exclude
    private User user;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "order_id")
    @MapsId
    private Order order;

    @NotNull
    @Column(name = "money_amount")
    private BigDecimal moneyAmount;

    public Payment(User user, Order order, BigDecimal moneyAmount) {
        this.user = user;
        this.order = order;
        this.moneyAmount = moneyAmount;
    }
}
