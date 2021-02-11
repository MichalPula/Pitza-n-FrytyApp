package PitzaNFryty.menu_item.drink;

import javax.persistence.*;

@Entity
@Table(name = "drinks_sizes")
public class DrinkSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "drink_size", unique = true)
    private DrinkSizePrice sizePrice;

    public DrinkSize(DrinkSizePrice sizePrice) {
        this.sizePrice = sizePrice;
    }

    public DrinkSize() {

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
