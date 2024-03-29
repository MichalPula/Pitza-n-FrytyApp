package PitzaNFryty.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping(value = "/{customerId}/addresses", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AddressReadDTO>> getCustomerAddresses(@PathVariable Long customerId) {
        return ResponseEntity.ok().body(addressService.getCustomerAddresses(customerId));
    }
}
