package PitzaNFryty.customer;

import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    Customer getById(Long userId);
}
