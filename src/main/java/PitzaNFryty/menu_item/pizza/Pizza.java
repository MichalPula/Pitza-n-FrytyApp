package PitzaNFryty.menu_item.pizza;

import PitzaNFryty.menu_item.MenuItem;
import PitzaNFryty.menu_item.ingredient.Ingredient;
import PitzaNFryty.menu_item.sauce.Sauce;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pizzas")
public class Pizza extends MenuItem {

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany
    @JoinTable(name = "pizza_ingredients")
    private List<Ingredient> ingredients;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany
    @JoinTable(name = "pizza_sauces")
    private List<Sauce> sauces;

    public Pizza(String name, List<Ingredient> ingredients, List<Sauce> sauces, boolean isAvailable, String imageURL) {
        super(name, isAvailable, imageURL);
    }

    public Pizza(String name, List<Ingredient> ingredients, List<Sauce> sauces, String imageURL) {
        super(name, imageURL);
    }

    public Pizza() {

    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Sauce> getSauces() {
        return sauces;
    }

    public void setSauces(List<Sauce> sauces) {
        this.sauces = sauces;
    }
}
