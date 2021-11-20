package PitzaNFryty.menu_item.drink;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class DrinkSizeConverter implements AttributeConverter<DrinkSize, String> {
    @Override
    public String convertToDatabaseColumn(DrinkSize drinkSize) {
        return switch (drinkSize) {
            case SMALL -> "Small";
            case LARGE -> "Large";
        };
    }

    @Override
    public DrinkSize convertToEntityAttribute(String string) {
        return switch (string) {
            case "Small" -> DrinkSize.SMALL;
            case "Large" -> DrinkSize.LARGE;
            default -> throw new IllegalArgumentException("Unknown " + string);
        };
    }
}
