package PitzaNFryty.menu_item.pizza;

import PitzaNFryty.menu_item.MenuItem;
import PitzaNFryty.menu_item.ingredient.Ingredient;
import PitzaNFryty.menu_item.sauce.Sauce;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "pizzas")
public class Pizza extends MenuItem {

    @Convert(converter = PizzaSizeConverter.class)
    private PizzaSize pizzaSize;

    @ManyToMany(targetEntity = Ingredient.class, fetch = FetchType.LAZY)
    @JoinTable(name = "pizza_ingredients",
            joinColumns = {@JoinColumn(name = "pizza_id")},
            inverseJoinColumns = {@JoinColumn(name = "ingredient_id")})
    private List<Ingredient> ingredients;

    @ManyToMany(targetEntity = Sauce.class, fetch = FetchType.LAZY)
    @JoinTable(name = "pizza_sauces",
            joinColumns = {@JoinColumn(name = "pizza_id")},
            inverseJoinColumns = {@JoinColumn(name = "sauce_id")})
    private List<Sauce> sauces;

    public Pizza(String name, PizzaSize pizzaSize, BigDecimal price, List<Ingredient> ingredients, List<Sauce> sauces, String imageURL) {
        super(name, imageURL, price);
        this.pizzaSize = pizzaSize;
        this.ingredients = ingredients;
        this.sauces = sauces;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getId()).append(" {");
        sb.append(this.getName()).append(", ");
        sb.append(this.pizzaSize.toString()).append(" - ");
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
