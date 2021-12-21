package PitzaNFryty.menu_item.pizza;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PizzaCreateDTO {

    private String name;
    private Map<String, BigDecimal> sizeToPrice;
    private List<Long> ingredientsIds;
    private List<Long> saucesIds;
    private String imageURL;
}
