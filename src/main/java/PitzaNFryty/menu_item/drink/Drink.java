package PitzaNFryty.menu_item.drink;

import PitzaNFryty.menu_item.MenuItem;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "drinks")
public class Drink extends MenuItem {

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity = DrinkSize.class)
    @JoinTable(name = "drinks_types")
    private List<DrinkSize> drinkSize;

    public Drink(String name, List<DrinkSize> drinkSize, boolean isAvailable, String imageURL) {
        super(name, isAvailable, imageURL);
        this.drinkSize = drinkSize;
    }

    public Drink(String name, List<DrinkSize> drinkSize, String imageURL) {
        super(name, imageURL);
        this.drinkSize = drinkSize;
    }

    public Drink() {
    }

    public List<DrinkSize> getDrinkTypes() {
        return drinkSize;
    }

    public void setDrinkTypes(List<DrinkSize> drinkSize) {
        this.drinkSize = drinkSize;
    }
}
