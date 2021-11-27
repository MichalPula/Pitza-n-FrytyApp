package PitzaNFryty.order;

import PitzaNFryty.address.Address;
import PitzaNFryty.address.AddressRepository;
import PitzaNFryty.customer.User;
import PitzaNFryty.customer.UserRepository;
import PitzaNFryty.customer.RegisteredCustomer.RegisteredUser;
import PitzaNFryty.customer.RegisteredCustomer.RegisteredCustomerRepository;
import PitzaNFryty.customer.UnregisteredCustomer.UnregisteredUser;
import PitzaNFryty.menu_item.MenuItem;
import PitzaNFryty.menu_item.MenuItemRepository;
import PitzaNFryty.payment.Payment;
import PitzaNFryty.payment.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    @PersistenceContext
    private EntityManager entityManager;

    private final RegisteredCustomerRepository registeredCustomerRepository;
    private final AddressRepository addressRepository;
    private final MenuItemRepository menuItemRepository;
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;
    private final UserRepository userRepository;

    @Autowired
    public OrderServiceImpl(RegisteredCustomerRepository registeredCustomerRepository, AddressRepository addressRepository,
                            MenuItemRepository menuItemRepository, OrderRepository orderRepository, PaymentRepository paymentRepository,
                            UserRepository userRepository) {
        this.registeredCustomerRepository = registeredCustomerRepository;
        this.addressRepository = addressRepository;
        this.menuItemRepository = menuItemRepository;
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<OrderReadDTORegistered> getCustomerOrders(Long customerId) {
        List<Tuple> dtos = entityManager.createNativeQuery("select mi.name, mi.price, o.id, o.creation_time from orders o " +
                "join orders_menu_items omi on omi.order_id = o.id " +
                "join menu_items mi on mi.id = omi.menu_item_id " +
                "where o.customer_id = :customerId", Tuple.class).setParameter("customerId", customerId).getResultList();

        Map<Integer, List<Tuple>> orderIdToTuple = new HashMap<>();
        for (Tuple tuple : dtos) {
            Integer orderId = tuple.get(2, BigInteger.class).intValue();
            if(orderIdToTuple.get(orderId) == null){
                orderIdToTuple.put(orderId, new ArrayList<>(Arrays.asList(tuple)));
            } else {
                orderIdToTuple.get(orderId).add(tuple);
            }
        }

        List<OrderReadDTORegistered> customersOrdersReadDTO = new ArrayList<>();
        orderIdToTuple.forEach((orderId, tuples) -> {
            OrderReadDTORegistered orderReadDTO = new OrderReadDTORegistered();
            orderReadDTO.setId(orderId);
            Map<String, BigDecimal> menuItemToPrice = new HashMap<>();
            tuples.forEach(tuple -> {
                menuItemToPrice.put(tuple.get(0, String.class), tuple.get(1, BigDecimal.class));
            });
            orderReadDTO.setMenuItemToPrice(menuItemToPrice);
            LocalDateTime creationTime = tuples.get(0).get(3, java.sql.Timestamp.class).toLocalDateTime();
            orderReadDTO.setCreationTime(creationTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
            customersOrdersReadDTO.add(orderReadDTO);
        });

        return customersOrdersReadDTO;
    }

    @Transactional
    @Override
    public String createOrderForRegisteredCustomer(OrderCreateDTORegistered registeredConsumersOrderRequest) {
        RegisteredUser registeredCustomer = registeredCustomerRepository.findById(registeredConsumersOrderRequest.getCustomerId()).orElseThrow();
        Address address = addressRepository.findById(registeredConsumersOrderRequest.getAddressId()).orElseThrow();
        List<MenuItem> menuItems = menuItemRepository.findAllById(registeredConsumersOrderRequest.getMenuItemsIds());

        return saveOrderAndPayment(registeredCustomer, address, menuItems, registeredConsumersOrderRequest.getMoneyAmount());
    }

    @Transactional
    @Override
    public String createOrderForUnregisteredCustomer(OrderCreateDTOUnregistered unregisteredCustomersOrderRequest) {
        UnregisteredUser unregisteredCustomer = new UnregisteredUser(
                unregisteredCustomersOrderRequest.getFirstName(),
                unregisteredCustomersOrderRequest.getLastName(),
                unregisteredCustomersOrderRequest.getEmail(),
                unregisteredCustomersOrderRequest.getPhoneNumber()
        );
        userRepository.save(unregisteredCustomer);

        Address address = new Address(unregisteredCustomer,
                unregisteredCustomersOrderRequest.getCity(),
                unregisteredCustomersOrderRequest.getZipCode(),
                unregisteredCustomersOrderRequest.getStreet(),
                unregisteredCustomersOrderRequest.getBuildingNumber(),
                unregisteredCustomersOrderRequest.getFlatNumber()
        );
        addressRepository.save(address);

        List<MenuItem> menuItems = menuItemRepository.findAllById(unregisteredCustomersOrderRequest.getMenuItemsIds());

        return saveOrderAndPayment(unregisteredCustomer, address, menuItems, unregisteredCustomersOrderRequest.getMoneyAmount());
    }

    private String saveOrderAndPayment(User user, Address address, List<MenuItem> menuItems, BigDecimal moneyAmount){
        Order order = new Order(user, address, menuItems, LocalDateTime.now());
        orderRepository.save(order);

        Payment payment = new Payment(user, order, moneyAmount);
        paymentRepository.save(payment);

        return "Order placed!";
    }
}
