package PitzaNFryty.menu_item.pizza;

import javax.persistence.*;

@Entity
@Table(name = "pizzas_sizes")
public class PizzaType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "pizza_size", unique = true)
    private PizzaSizePrice sizePrice;

    public PizzaType(PizzaSizePrice sizePrice) {
        this.sizePrice = sizePrice;
    }

    public PizzaType() {

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
