package PitzaNFryty.menu_item.fries;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FriesSize {
    SMALL(50),
    MEDIUM(100),
    LARGE(200);

    private final Integer weight;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString().charAt(0));
        sb.append(super.toString().substring(1).toLowerCase());
        return sb.toString();
    }
}
