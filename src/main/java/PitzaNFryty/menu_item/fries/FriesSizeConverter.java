package PitzaNFryty.menu_item.fries;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class FriesSizeConverter implements AttributeConverter<FriesSize, String> {
    @Override
    public String convertToDatabaseColumn(FriesSize friesSize) {
        return switch (friesSize) {
            case SMALL -> "Small";
            case MEDIUM -> "Medium";
            case LARGE -> "Large";
            default -> throw new IllegalArgumentException("Unknown " + friesSize);
        };
    }

    @Override
    public FriesSize convertToEntityAttribute(String string) {
        return switch (string) {
            case "Small" -> FriesSize.SMALL;
            case "Medium" -> FriesSize.MEDIUM;
            case "Large" -> FriesSize.LARGE;
            default -> throw new IllegalArgumentException("Unknown " + string);
        };
    }
}
