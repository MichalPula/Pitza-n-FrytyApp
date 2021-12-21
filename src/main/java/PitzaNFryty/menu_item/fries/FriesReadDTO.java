package PitzaNFryty.menu_item.fries;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FriesReadDTO {

    private String name;
    private Map<Long, List<String>> friesIdToSizeWeightPriceList;
    private String imageURL;
}
