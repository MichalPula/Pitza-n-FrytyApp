package PitzaNFryty.order;

import PitzaNFryty.address.Address;
import PitzaNFryty.customer.User;
import PitzaNFryty.menu_item.MenuItem;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    private Long id;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(targetEntity = Address.class)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany(targetEntity = MenuItem.class, cascade = CascadeType.MERGE)
    @JoinTable(name = "orders_menu_items",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "menu_item_id")})
    private List<? extends MenuItem> menuItems;

    @NotNull
    @Column(name = "creation_time")
    private LocalDateTime creationTime;

    public Order(User user, Address address, List<MenuItem> menuItems, LocalDateTime creationTime) {
        this.user = user;
        this.address = address;
        this.menuItems = menuItems;
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("id=").append(id);
        sb.append(", menuItems=").append(menuItems);
        sb.append(", creationTime=").append(creationTime);
        sb.append('}');
        return sb.toString();
    }
}
