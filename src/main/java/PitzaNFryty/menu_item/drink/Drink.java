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
    @ManyToMany(targetEntity = DrinkType.class)
    @JoinTable(name = "drinks_types")
    private List<DrinkType> drinkType;

    public Drink() {
    }

    public Drink(String name, List<DrinkType> drinkType, boolean available, String imageURL) {
        super(name, available, imageURL);
        this.drinkType = drinkType;
    }

    public List<DrinkType> getDrinkTypes() {
        return drinkType;
    }

    public void setDrinkTypes(List<DrinkType> drinkType) {
        this.drinkType = drinkType;
    }
}
