package PitzaNFryty.customer.RegisteredCustomer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisteredCustomerRepository extends JpaRepository<RegisteredCustomer, Long> {
    RegisteredCustomer findRegisteredCustomerByEmail(String username);
}
