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
    @OneToMany(targetEntity = PizzaSize.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "pizzas_sizes",
            joinColumns = {@JoinColumn(name = "pizza_id")},
            inverseJoinColumns = {@JoinColumn(name = "pizza_size_id")})
    private Set<PizzaSize> pizzaSizes;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(targetEntity = Ingredient.class, cascade = CascadeType.MERGE)
    @JoinTable(name = "pizza_ingredients",
            joinColumns = {@JoinColumn(name = "pizza_id")},
            inverseJoinColumns = {@JoinColumn(name = "ingredient_id")})
    private List<Ingredient> ingredients;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(targetEntity = Sauce.class, cascade = CascadeType.MERGE)
    @JoinTable(name = "pizza_sauces",
            joinColumns = {@JoinColumn(name = "pizza_id")},
            inverseJoinColumns = {@JoinColumn(name = "sauce_id")})
    private List<Sauce> sauces;

    public Pizza(String name, Set<PizzaSize> pizzaSizes, List<Ingredient> ingredients, List<Sauce> sauces, String imageURL) {
        super(name, imageURL);
        this.pizzaSizes = pizzaSizes;
        this.ingredients = ingredients;
        this.sauces = sauces;
    }

    public Pizza() {
    }

    public Set<PizzaSize> getPizzaTypes() {
        return pizzaSizes;
    }

    public void setPizzaTypes(Set<PizzaSize> pizzaSizes) {
        this.pizzaSizes = pizzaSizes;
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
        this.pizzaSizes.forEach(pizzaSize ->
            sb.append("[")
                    .append(pizzaSize.getSizePrice().name()).append(", ")
                    .append(pizzaSize.getSizePrice().getDiameter()).append("cm, ")
                    .append(pizzaSize.getSizePrice().getPrice()).append("PLN")
                    .append("] "));
        sb.append(getImageURL());
        return sb.toString();
    }
}
