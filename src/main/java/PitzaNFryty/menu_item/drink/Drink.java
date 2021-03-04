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
    @OneToMany(targetEntity = DrinkSize.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "drinks_sizes",
            joinColumns = {@JoinColumn(name = "drink_id")},
            inverseJoinColumns = {@JoinColumn(name = "drink_size_id")})
    private Set<DrinkSize> drinkSizes;

    public Drink(String name, Set<DrinkSize> drinkSizes, boolean isAvailable, String imageURL) {
        super(name, isAvailable, imageURL);
        this.drinkSizes = drinkSizes;
    }

    public Drink(String name, Set<DrinkSize> drinkSizes, String imageURL) {
        super(name, imageURL);
        this.drinkSizes = drinkSizes;
    }

    public Drink() {
    }

    public Set<DrinkSize> getDrinkSizes() {
        return drinkSizes;
    }

    public void setDrinkSizes(Set<DrinkSize> drinkSizes) {
        this.drinkSizes = drinkSizes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName())
                .append("[");
        this.drinkSizes.forEach(drinkSize -> sb.append(drinkSize.toString()).append(", "));
        sb.append("]");
        return sb.toString();
    }
}
