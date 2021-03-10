package PitzaNFryty.address;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.ArrayList;
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
    public List<AddressReadDTO> getUserAddresses(Long userId) {
        TypedQuery<Address> typedQuery = entityManager.createQuery("SELECT a FROM Address a WHERE a.customer.id =: userId", Address.class);
        typedQuery.setParameter("userId", userId);
        List<Address> result = typedQuery.getResultList();

        List<AddressReadDTO> addressReadDTOList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        result.forEach(address -> {
            addressReadDTOList.add(modelMapper.map(address, AddressReadDTO.class));
        });

        return addressReadDTOList;
    }
}
