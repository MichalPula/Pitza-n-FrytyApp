package PitzaNFryty.menu_item.drink;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DrinkSize {
    SMALL(0.3),
    LARGE(0.7);

    private final Double volume;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString().charAt(0));
        sb.append(super.toString().substring(1).toLowerCase());
        return sb.toString();
    }
}
