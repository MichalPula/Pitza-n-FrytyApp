package PitzaNFryty.menu_item.pizza;

import PitzaNFryty.menu_item.MenuItem;
import PitzaNFryty.menu_item.ingredient.Ingredient;
import PitzaNFryty.menu_item.sauce.Sauce;
import com.sun.istack.NotNull;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "pizzas")
public class Pizza extends MenuItem {

    @NotNull
    @ManyToOne(targetEntity = PizzaSize.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "pizza_size_id")
    private PizzaSize pizzaSize;

    @NotNull
    @Column(name = "price")
    private BigDecimal price;

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

    public Pizza(String name, PizzaSize pizzaSize, BigDecimal price, List<Ingredient> ingredients, List<Sauce> sauces, String imageURL) {
        super(name, imageURL);
        this.pizzaSize = pizzaSize;
        this.ingredients = ingredients;
        this.sauces = sauces;
        this.price = price;
    }

    public Pizza() {
    }

    public PizzaSize getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(PizzaSize pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
        sb.append(this.getId()).append(" {");
        sb.append(this.getName()).append(", ");
        sb.append(this.pizzaSize.toString()).append(" - ");
        sb.append(this.price).append(", [");
//        this.ingredients.forEach(ingredient ->
//                sb.append(ingredient.getName()).append(", "));
//        sb.append("], [");
//        this.sauces.forEach(sauce ->
//                sb.append(sauce.getName()).append(", "));
        sb.append("], ");
        sb.append(getImageURL());
        sb.append("}");
        return sb.toString();
    }
}
