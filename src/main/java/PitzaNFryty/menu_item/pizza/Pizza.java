package PitzaNFryty.menu_item.pizza;

import PitzaNFryty.menu_item.MenuItem;
import PitzaNFryty.menu_item.ingredient.Ingredient;
import PitzaNFryty.menu_item.sauce.Sauce;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "pizzas")
public class Pizza extends MenuItem {

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity = PizzaType.class)
    @JoinTable(name = "pizzas_types")
    private Set<PizzaType> pizzaTypes;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(targetEntity = Ingredient.class)
    @JoinTable(name = "pizza_ingredients")
    private List<Ingredient> ingredients;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(targetEntity = Sauce.class)
    @JoinTable(name = "pizza_sauces")
    private List<Sauce> sauces;

    public Pizza(String name, Set<PizzaType> pizzaTypes, List<Ingredient> ingredients, List<Sauce> sauces, String imageURL) {
        super(name, imageURL);
        this.pizzaTypes = pizzaTypes;
        this.ingredients = ingredients;
        this.sauces = sauces;
    }

    public Pizza() {

    }

    public Set<PizzaType> getPizzaTypes() {
        return pizzaTypes;
    }

    public void setPizzaTypes(Set<PizzaType> pizzaTypes) {
        this.pizzaTypes = pizzaTypes;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName());
        sb.append(", [");
        this.ingredients.forEach(ingredient ->
                sb.append(ingredient.getName()).append(", "));
        sb.append("], [");
        this.sauces.forEach(sauce ->
                sb.append(sauce.getName()).append(", "));
        sb.append("], ");
        this.pizzaTypes.forEach(pizzaType ->
                sb.append(pizzaType.getSizePrice().name()).append(", ")
                .append(pizzaType.getSizePrice().getPrice()).append("PLN, ")
                .append(pizzaType.getSizePrice().getDiameter()).append("cm, "));
        sb.append(getImageURL());
        return sb.toString();
    }
}
