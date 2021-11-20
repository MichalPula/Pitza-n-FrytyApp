package PitzaNFryty.order;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    List<OrderReadDTORegistered> getCustomerOrders(Long customerId);
}
