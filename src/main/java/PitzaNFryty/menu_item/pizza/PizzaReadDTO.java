package PitzaNFryty.menu_item.pizza;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PizzaReadDTO {

    private String name;
    private Map<Long, List<String>> pizzaIdToSizeDiameterPriceList;
    private Map<Long, String> ingredients;
    private Map<Long, String> sauces;
    private String imageURL;
}
