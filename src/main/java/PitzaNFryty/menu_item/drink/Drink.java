package PitzaNFryty.menu_item.drink;

import PitzaNFryty.menu_item.MenuItem;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "drinks")
public class Drink extends MenuItem {

    @NotNull
    @ManyToOne(targetEntity = DrinkSize.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "drink_size_id")
    private DrinkSize drinkSize;

    @NotNull
    @Column(name = "price")
    private BigDecimal price;

    public Drink(String name, DrinkSize drinkSize, BigDecimal price, String imageURL) {
        super(name, imageURL);
        this.drinkSize = drinkSize;
        this.price = price;
    }

    public Drink() {
    }

    public DrinkSize getDrinkSize() {
        return drinkSize;
    }

    public void setDrinkSize(DrinkSize drinkSize) {
        this.drinkSize = drinkSize;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.getId() + " {" + this.getName() + ", " + this.drinkSize.toString() +", " + this.price + ", " + this.getImageURL() + "}";
    }
}
