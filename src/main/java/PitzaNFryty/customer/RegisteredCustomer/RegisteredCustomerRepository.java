package PitzaNFryty.customer.RegisteredCustomer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisteredCustomerRepository extends JpaRepository<RegisteredUser, Long> {
    RegisteredUser findRegisteredCustomerByEmail(String username);
}
