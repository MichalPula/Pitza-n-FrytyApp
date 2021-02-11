package PitzaNFryty.menu_item.drink;

import javax.persistence.*;

@Entity
@Table(name = "drink_types")
public class DrinkType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated
    @Column(name = "size_price", unique = true)
    private DrinkSizePrice sizePrice;
}
