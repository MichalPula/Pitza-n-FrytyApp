package PitzaNFryty.menu_item.drink;

import lombok.*;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DrinkCreateDTO {

    private String name;
    private Map<String, BigDecimal> sizeToPrice;
    private String imageURL;
}
