package PitzaNFryty.menu_item.fries;

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
@Table(name = "fries")
public class Fries extends MenuItem {

    @Convert(converter = FriesSizeConverter.class)
    private FriesSize friesSize;

    public Fries(String name, FriesSize friesSize, BigDecimal price, String imageURL) {
        super(name, imageURL, price);
        this.friesSize = friesSize;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fries{");
        sb.append("name='").append(name).append('\'');
        sb.append(", isAvailable=").append(isAvailable);
        sb.append(", price=").append(price);
        sb.append(", imageURL='").append(imageURL).append('\'');
        sb.append(", friesSize=").append(friesSize);
        sb.append('}');
        return sb.toString();
    }
}
