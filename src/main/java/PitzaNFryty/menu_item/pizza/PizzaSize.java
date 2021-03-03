package PitzaNFryty.menu_item.pizza;

import javax.persistence.*;

@Entity
@Table(name = "pizzas_sizes_prices")
public class PizzaSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "pizza_size_price", unique = true)
    private PizzaSizePrice sizePrice;

    public PizzaSize(PizzaSizePrice sizePrice) {
        this.sizePrice = sizePrice;
    }

    public PizzaSize() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PizzaSizePrice getSizePrice() {
        return sizePrice;
    }

    public void setSizePrice(PizzaSizePrice sizePrice) {
        this.sizePrice = sizePrice;
    }

    @Override
    public String toString() {
        return this.getSizePrice().name() + "-" +
                this.getSizePrice().getPrice() + "-" +
                this.getSizePrice().getDiameter()+"cm";
    }
}
