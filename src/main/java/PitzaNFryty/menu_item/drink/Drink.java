package PitzaNFryty.menu_item.drink;

import PitzaNFryty.menu_item.MenuItem;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "drinks")
public class Drink extends MenuItem {

    @OneToMany
    private Set<DrinkType> drinkTypes;

    public Drink() {
    }

    public Drink(String name, Set<DrinkType> drinkTypes, boolean available, String imageURL) {
        super(name, available, imageURL);
        this.drinkTypes = drinkTypes;
    }

    public Set<DrinkType> getDrinkTypes() {
        return drinkTypes;
    }

    public void setDrinkTypes(Set<DrinkType> drinkTypes) {
        this.drinkTypes = drinkTypes;
    }
}
