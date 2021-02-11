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
    @ManyToMany(targetEntity = DrinkSize.class)
    @JoinTable(name = "drinks_types")
    private List<DrinkSize> drinkSize;

    public Drink() {
    }

    public Drink(String name, List<DrinkSize> drinkSize, boolean available, String imageURL) {
        super(name, available, imageURL);
        this.drinkSize = drinkSize;
    }

    public List<DrinkSize> getDrinkTypes() {
        return drinkSize;
    }

    public void setDrinkTypes(List<DrinkSize> drinkSize) {
        this.drinkSize = drinkSize;
    }
}
