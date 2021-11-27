package PitzaNFryty.customer;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User getById(Long userId);
}
