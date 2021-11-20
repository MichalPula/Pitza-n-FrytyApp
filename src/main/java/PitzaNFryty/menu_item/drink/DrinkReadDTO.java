package PitzaNFryty.menu_item.drink;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DrinkReadDTO {

    private String name;
    private Map<Long, List<String>> drinkIdToSizeVolumePriceList;
    private String imageURL;
}
