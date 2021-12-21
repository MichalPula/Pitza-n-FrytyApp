package PitzaNFryty.order;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderCreateDTORegistered {

    private Long customerId;
    private Long addressId;
    private List<Long> menuItemsIds;
    private BigDecimal moneyAmount;
}
