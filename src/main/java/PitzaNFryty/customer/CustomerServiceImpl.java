package PitzaNFryty.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class CustomerServiceImpl implements CustomerService {

    @PersistenceContext
    private EntityManager entityManager;

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getById(Long userId) {
        //Session session = entityManager.unwrap(Session.class);
        //Query query = session.createQuery("from Address a where a.customer.id =: userId", Address.class);
        //Query query = session.createQuery("from Address a join fetch a.customer where a.customer.id =: userId", Address.class);
        //query.setParameter("userId", userId);

        //@SuppressWarnings("unchecked")
        //List<Address> result = query.getResultList();

        //List<AddressReadDTO> addressReadDTOList = new ArrayList<>();
//        ModelMapper modelMapper = new ModelMapper();
//        result.forEach(address -> {
//            addressReadDTOList.add(modelMapper.map(address, AddressReadDTO.class));
//        });

        Customer customer = customerRepository.getOne(1L);
        return customer;
    }
}
