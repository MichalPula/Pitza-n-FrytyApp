package PitzaNFryty.menu_item.pizza;

import java.math.BigDecimal;
import java.util.Map;

public class PizzaReadDTO {

    private String name;
    private Map<Long, PizzaSize> pizzaIdToSize;
    private Map<Long, BigDecimal> pizzaIdToPrice;
    private Map<Long, String> ingredients;
    private Map<Long, String> sauces;
    private String imageURL;

    public PizzaReadDTO(String name, Map<Long, PizzaSize> pizzaIdToSize,
                        Map<Long, String> ingredients, Map<Long, String> sauces, String imageURL) {
        this.name = name;
        this.pizzaIdToSize = pizzaIdToSize;
        this.ingredients = ingredients;
        this.sauces = sauces;
        this.imageURL = imageURL;
    }

    public PizzaReadDTO() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Long, PizzaSize> getPizzaIdToSize() {
        return pizzaIdToSize;
    }

    public void setPizzaIdToSize(Map<Long, PizzaSize> pizzaIdToSize) {
        this.pizzaIdToSize = pizzaIdToSize;
    }

    public Map<Long, BigDecimal> getPizzaIdToPrice() {
        return pizzaIdToPrice;
    }

    public void setPizzaIdToPrice(Map<Long, BigDecimal> pizzaIdToPrice) {
        this.pizzaIdToPrice = pizzaIdToPrice;
    }

    public Map<Long, String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map<Long, String> ingredients) {
        this.ingredients = ingredients;
    }

    public Map<Long, String> getSauces() {
        return sauces;
    }

    public void setSauces(Map<Long, String> sauces) {
        this.sauces = sauces;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PizzaReadDTO{");
        sb.append("name='").append(name).append('\'');
        sb.append(", pizzaIdToSize=").append(pizzaIdToSize);
        sb.append(", pizzaIdToPrice=").append(pizzaIdToPrice);
        sb.append(", ingredients=").append(ingredients);
        sb.append(", sauces=").append(sauces);
        sb.append(", imageURL='").append(imageURL).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
