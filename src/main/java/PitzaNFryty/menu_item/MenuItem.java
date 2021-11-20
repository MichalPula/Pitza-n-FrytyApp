package PitzaNFryty.menu_item;

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
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "menu_items")
public class MenuItem {

    @Id
    @SequenceGenerator(name = "menu_item_id_generator", sequenceName = "menu_item_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_item_id_generator")
    @Column(name = "id", unique = true, updatable = false)
    private long id;

    @NotNull
    @Column(name = "name")
    protected String name;

    @Column(name = "is_available")
    protected boolean isAvailable = true;

    @Column(name = "price")
    protected BigDecimal price;

    @NotNull
    @Column(name = "image_url")
    protected String imageURL;

    public MenuItem(String name, String imageURL, BigDecimal price) {
        this.name = name;
        this.imageURL = imageURL;
        this.price = price;
    }
}
