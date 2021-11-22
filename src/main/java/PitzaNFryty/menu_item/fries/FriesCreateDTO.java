package PitzaNFryty.menu_item.fries;

import lombok.*;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FriesCreateDTO {

    private String name;
    private Map<String, BigDecimal> sizeToPrice;
    private String imageURL;
}
