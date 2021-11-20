package PitzaNFryty.order;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderCreateDTOUnregistered {

    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String email;

    private String city;
    private String zipCode;
    private String street;
    private String buildingNumber;
    private String flatNumber;

    private List<Long> menuItemsIds;

    private BigDecimal moneyAmount;


}
