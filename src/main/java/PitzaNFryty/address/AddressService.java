package PitzaNFryty.address;

import PitzaNFryty.customer.UnregisteredCustomer.UnregisteredCustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    List<AddressReadDTO> getCustomerAddresses(Long customerId);
}
