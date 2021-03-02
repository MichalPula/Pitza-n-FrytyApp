package PitzaNFryty.menu_item.drink;

import PitzaNFryty.menu_item.MenuItem;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "drinks")
public class Drink extends MenuItem {

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity = DrinkType.class)
    @JoinTable(name = "drinks_types")
    private Set<DrinkType> drinkType;

    public Drink(String name, Set<DrinkType> drinkType, boolean isAvailable, String imageURL) {
        super(name, isAvailable, imageURL);
        this.drinkType = drinkType;
    }

    public Drink(String name, Set<DrinkType> drinkType, String imageURL) {
        super(name, imageURL);
        this.drinkType = drinkType;
    }

    public Drink() {
    }

    public Set<DrinkType> getDrinkTypes() {
        return drinkType;
    }

    public void setDrinkTypes(Set<DrinkType> drinkType) {
        this.drinkType = drinkType;
    }
}
