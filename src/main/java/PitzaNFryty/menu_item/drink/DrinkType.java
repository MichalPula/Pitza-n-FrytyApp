package PitzaNFryty.menu_item.drink;

import javax.persistence.*;

@Entity
@Table(name = "drink_sizes")
public class DrinkType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "drink_size", unique = true)
    private DrinkSizePrice sizePrice;

    public DrinkType(DrinkSizePrice sizePrice) {
        this.sizePrice = sizePrice;
    }

    public DrinkType() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DrinkSizePrice getSizePrice() {
        return sizePrice;
    }

    public void setSizePrice(DrinkSizePrice sizePrice) {
        this.sizePrice = sizePrice;
    }

    @Override
    public String toString() {
        return this.getSizePrice().name() + "-" +
                this.getSizePrice().getPrice();
    }
}
