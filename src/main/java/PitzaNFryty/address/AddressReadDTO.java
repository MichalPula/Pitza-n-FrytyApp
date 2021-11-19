package PitzaNFryty.address;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressReadDTO {

    private Long id;
    private String city;
    private String zipCode;
    private String street;
    private String buildingNumber;
    private String flatNumber;

}
