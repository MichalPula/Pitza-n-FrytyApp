package PitzaNFryty.menu_item.drink;

import PitzaNFryty.menu_item.MenuItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "drinks")
public class Drink extends MenuItem {

    @Convert(converter = DrinkSizeConverter.class)
    private DrinkSize drinkSize;

    public Drink(String name, DrinkSize drinkSize, BigDecimal price, String imageURL) {
        super(name, imageURL, price);
        this.drinkSize = drinkSize;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Drink{");
        sb.append("name='").append(name).append('\'');
        sb.append(", isAvailable=").append(isAvailable);
        sb.append(", price=").append(price);
        sb.append(", imageURL='").append(imageURL).append('\'');
        sb.append(", drinkSize=").append(drinkSize);
        sb.append('}');
        return sb.toString();
    }
}
