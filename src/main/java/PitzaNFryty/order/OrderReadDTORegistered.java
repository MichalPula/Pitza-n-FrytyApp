package PitzaNFryty.order;

import lombok.*;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderReadDTORegistered {

    private Integer id;
    private Map<String, BigDecimal> menuItemToPrice;
    private String creationTime;
}
