package PitzaNFryty.menu_item.pizza;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PizzaSize {
    SMALL(30),
    MEDIUM(40),
    LARGE(50);

    private final Integer diameter;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString().charAt(0));
        sb.append(super.toString().substring(1).toLowerCase());
        return sb.toString();
    }
}
