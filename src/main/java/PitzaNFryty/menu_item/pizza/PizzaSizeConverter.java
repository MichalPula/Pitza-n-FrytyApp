package PitzaNFryty.menu_item.pizza;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class PizzaSizeConverter implements AttributeConverter<PizzaSize, String> {
    @Override
    public String convertToDatabaseColumn(PizzaSize pizzaSize) {
        return switch (pizzaSize) {
            case SMALL -> "Small";
            case MEDIUM -> "Medium";
            case LARGE -> "Large";
        };
    }

    @Override
    public PizzaSize convertToEntityAttribute(String string) {
        return switch (string) {
            case "Small" -> PizzaSize.SMALL;
            case "Medium" -> PizzaSize.MEDIUM;
            case "Large" -> PizzaSize.LARGE;
            default -> throw new IllegalArgumentException("Unknown " + string);
        };
    }
}
