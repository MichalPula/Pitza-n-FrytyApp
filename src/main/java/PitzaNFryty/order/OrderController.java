package PitzaNFryty.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/{customerId}/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderReadDTORegistered>> getCustomerOrders(@PathVariable Long customerId) {
        return ResponseEntity.ok().body(orderService.getCustomerOrders(customerId));
    }
}
