package PitzaNFryty.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @PersistenceContext
    private EntityManager entityManager;

    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<AddressReadDTO> getCustomerAddresses(Long customerId) {
        return addressRepository.getCustomerAddresses(customerId);
    }

}
