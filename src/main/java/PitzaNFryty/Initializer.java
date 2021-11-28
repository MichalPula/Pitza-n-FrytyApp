package PitzaNFryty;

import PitzaNFryty.address.Address;
import PitzaNFryty.address.AddressRepository;
import PitzaNFryty.address.AddressService;
import PitzaNFryty.customer.RegisteredUser.RegisteredUser;
import PitzaNFryty.customer.RegisteredUser.RegisteredUserRepository;
import PitzaNFryty.customer.UnregisteredUser.UnregisteredUser;
import PitzaNFryty.customer.UnregisteredUser.UnregisteredUserRepository;
import PitzaNFryty.customer.UserRepository;
import PitzaNFryty.jwt_authentication.role.Role;
import PitzaNFryty.menu_item.MenuItemRepository;
import PitzaNFryty.menu_item.drink.Drink;
import PitzaNFryty.menu_item.drink.DrinkRepository;
import PitzaNFryty.menu_item.drink.DrinkSize;
import PitzaNFryty.menu_item.fries.Fries;
import PitzaNFryty.menu_item.fries.FriesRepository;
import PitzaNFryty.menu_item.fries.FriesSize;
import PitzaNFryty.menu_item.ingredient.Ingredient;
import PitzaNFryty.menu_item.ingredient.IngredientRepository;
import PitzaNFryty.menu_item.pizza.Pizza;
import PitzaNFryty.menu_item.pizza.PizzaRepository;
import PitzaNFryty.menu_item.pizza.PizzaSize;
import PitzaNFryty.menu_item.sauce.Sauce;
import PitzaNFryty.menu_item.sauce.SauceRepository;
import PitzaNFryty.order.OrderCreateDTORegistered;
import PitzaNFryty.order.OrderCreateDTOUnregistered;
import PitzaNFryty.order.OrderRepository;
import PitzaNFryty.order.OrderService;
import PitzaNFryty.payment.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class Initializer {

    private final DrinkRepository drinkRepository;
    private final FriesRepository friesRepository;
    private final IngredientRepository ingredientRepository;
    private final SauceRepository sauceRepository;
    private final PizzaRepository pizzaRepository;
    private final AddressRepository addressRepository;
    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final MenuItemRepository menuItemRepository;
    private final RegisteredUserRepository registeredUserRepository;
    private final UnregisteredUserRepository unregisteredUserRepository;
    private final AddressService addressService;
    private final OrderService orderService;
    private final BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public Initializer(DrinkRepository drinkRepository, FriesRepository friesRepository, IngredientRepository ingredientRepository,
                       SauceRepository sauceRepository, PizzaRepository pizzaRepository, AddressRepository addressRepository,
                       PaymentRepository paymentRepository, OrderRepository orderRepository, UserRepository userRepository,
                       MenuItemRepository menuItemRepository, RegisteredUserRepository registeredUserRepository,
                       UnregisteredUserRepository unregisteredUserRepository,
                       AddressService addressService, OrderService orderService, BCryptPasswordEncoder passwordEncoder) {
        this.drinkRepository = drinkRepository;
        this.friesRepository = friesRepository;
        this.ingredientRepository = ingredientRepository;
        this.sauceRepository = sauceRepository;
        this.pizzaRepository = pizzaRepository;
        this.addressRepository = addressRepository;
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.menuItemRepository = menuItemRepository;
        this.registeredUserRepository = registeredUserRepository;
        this.unregisteredUserRepository = unregisteredUserRepository;
        this.addressService = addressService;
        this.orderService = orderService;
        this.passwordEncoder = passwordEncoder;

        initializeData();
    }


    private void initializeData(){
        Drink cocaColaS = new Drink("Coca-Cola", DrinkSize.SMALL, new BigDecimal(5),"cocacolaurl");
        Drink cocaColaL = new Drink("Coca-Cola", DrinkSize.LARGE, new BigDecimal(8),"cocacolaurl");
        Drink pepsiS = new Drink("Pepsi", DrinkSize.SMALL, new BigDecimal(5),"pepsiurl");
        Drink pepsiL = new Drink("Pepsi", DrinkSize.LARGE, new BigDecimal(8),"pepsiurl");
        Drink fantaS = new Drink("Fanta", DrinkSize.SMALL, new BigDecimal(5),"fantaurl");
        Drink fantaL = new Drink("Fanta", DrinkSize.LARGE, new BigDecimal(8),"fantaurl");
        Drink spriteS = new Drink("Sprite", DrinkSize.SMALL, new BigDecimal(5),"spriteurl");
        Drink spriteL = new Drink("Sprite", DrinkSize.LARGE, new BigDecimal(8),"spriteurl");
        Drink mirindaS = new Drink("Mirinda", DrinkSize.SMALL, new BigDecimal(5),"mirindaurl");
        Drink mirindaL = new Drink("Mirinda", DrinkSize.LARGE, new BigDecimal(8),"mirindaurl");
        Drink orangeJuiceS = new Drink("Orange juice", DrinkSize.SMALL, new BigDecimal(5),"orangejuiceurl");
        Drink orangeJuiceL = new Drink("Orange juice", DrinkSize.LARGE, new BigDecimal(8),"orangejuiceurl");
        Drink appleJuiceS = new Drink("Apple juice", DrinkSize.SMALL, new BigDecimal(5),"applejuiceurl");
        Drink appleJuiceL = new Drink("Apple juice", DrinkSize.LARGE, new BigDecimal(8),"applejuiceurl");
        drinkRepository.saveAll(Arrays.asList(cocaColaS, cocaColaL, pepsiS, pepsiL, fantaS, fantaL,
                spriteS, spriteL, mirindaS, mirindaL, orangeJuiceS, orangeJuiceL, appleJuiceS, appleJuiceL));


        Fries smallFries = new Fries("Fries", FriesSize.SMALL, new BigDecimal(3), "friesurl");
        Fries mediumFries = new Fries("Fries", FriesSize.MEDIUM, new BigDecimal(4), "friesurl");
        Fries largeFries =new Fries("Fries", FriesSize.LARGE, new BigDecimal(5), "friesurl");
        Fries smallCheeseFries = new Fries("Cheese Fries", FriesSize.SMALL, new BigDecimal(4), "cheesefriesurl");
        Fries mediumCheeseFries = new Fries("Cheese Fries", FriesSize.MEDIUM, new BigDecimal(5), "cheesefriesurl");
        Fries largeCheeseFries = new Fries("Cheese Fries", FriesSize.LARGE, new BigDecimal(6), "cheesefriesurl");
        friesRepository.saveAll(Arrays.asList(smallFries, mediumFries, largeFries, smallCheeseFries, mediumCheeseFries, largeCheeseFries));


        Ingredient mozzarella = new Ingredient("Mozzarella cheese");
        Ingredient tomatoSauce = new Ingredient("Tomato sauce");
        Ingredient oregano = new Ingredient("Oregano");
        Ingredient ham = new Ingredient("Ham");
        Ingredient mushrooms = new Ingredient("Mushrooms");
        Ingredient pineapple = new Ingredient("Pineapple");
        Ingredient chicken = new Ingredient("Chicken");
        Ingredient greenPepper = new Ingredient("Green pepper");
        Ingredient redOnion = new Ingredient("Red onion");
        Ingredient bacon = new Ingredient("Bacon");
        Ingredient beef = new Ingredient("Beef");
        Ingredient pepperoni = new Ingredient("Pepperoni");
        Ingredient parmaHam = new Ingredient("Parma ham");
        Ingredient cherryTomatoes = new Ingredient("Cherry tomatoes");
        Ingredient arugula = new Ingredient("Arugula");
        Ingredient parmesanCheese = new Ingredient("Parmesan cheese");
        Ingredient cheddarCheese = new Ingredient("Cheddar cheese");
        List<Ingredient> allIngredients = new ArrayList<>(Arrays.asList(mozzarella, tomatoSauce, oregano, ham, mushrooms, pineapple,
                chicken, greenPepper, redOnion, bacon, beef, pepperoni, parmaHam, cherryTomatoes, arugula, parmesanCheese, cheddarCheese));
        ingredientRepository.saveAll(allIngredients);
        List<Ingredient> basicIngredients = Arrays.asList(mozzarella, tomatoSauce, oregano);

        Sauce ketchup = new Sauce("Ketchup");
        Sauce garlicSauce = new Sauce("Garlic sauce");
        Sauce bbqSauce = new Sauce("BBQ sauce");
        Sauce jalapenoSauce = new Sauce("Jalapeno sauce");
        List<Sauce> allSauces = new ArrayList<>(Arrays.asList(ketchup, garlicSauce, bbqSauce, jalapenoSauce));
        sauceRepository.saveAll(allSauces);
        List<Sauce> basicSauces = Arrays.asList(ketchup, garlicSauce);




        Pizza margheritaS = new Pizza("Margherita", PizzaSize.SMALL, new BigDecimal(21), basicIngredients, basicSauces, "https://images.pexels.com/photos/1260968/pexels-photo-1260968.jpeg");
        Pizza margheritaM = new Pizza("Margherita", PizzaSize.MEDIUM, new BigDecimal(28), basicIngredients, basicSauces, "https://images.pexels.com/photos/1260968/pexels-photo-1260968.jpeg");
        Pizza margheritaL = new Pizza("Margherita", PizzaSize.LARGE, new BigDecimal(32), basicIngredients, basicSauces, "https://images.pexels.com/photos/1260968/pexels-photo-1260968.jpeg");

        List<Ingredient> capricciosaIngredients = new ArrayList<>(basicIngredients);
        capricciosaIngredients.addAll(Arrays.asList(ham, mushrooms));
        Pizza capricciosaS = new Pizza("Capricciosa", PizzaSize.SMALL, new BigDecimal(25), capricciosaIngredients, basicSauces, "https://images.pexels.com/photos/1260968/pexels-photo-1260968.jpeg");
        Pizza capricciosaM = new Pizza("Capricciosa", PizzaSize.MEDIUM, new BigDecimal(31), capricciosaIngredients, basicSauces, "https://images.pexels.com/photos/1260968/pexels-photo-1260968.jpeg");
        Pizza capricciosaL = new Pizza("Capricciosa", PizzaSize.LARGE, new BigDecimal(39), capricciosaIngredients, basicSauces, "https://images.pexels.com/photos/1260968/pexels-photo-1260968.jpeg");

        List<Ingredient> pepperoniIngredients = new ArrayList<>(basicIngredients);
        pepperoniIngredients.addAll(Arrays.asList(pepperoni));
        Pizza pepperoniPizzaS = new Pizza("Pepperoni", PizzaSize.SMALL, new BigDecimal(23), pepperoniIngredients, basicSauces, "https://images.pexels.com/photos/1260968/pexels-photo-1260968.jpeg");
        Pizza pepperoniPizzaM = new Pizza("Pepperoni", PizzaSize.MEDIUM, new BigDecimal(30), pepperoniIngredients, basicSauces, "https://images.pexels.com/photos/1260968/pexels-photo-1260968.jpeg");
        Pizza pepperoniPizzaL = new Pizza("Pepperoni", PizzaSize.LARGE, new BigDecimal(37), pepperoniIngredients, basicSauces, "https://images.pexels.com/photos/1260968/pexels-photo-1260968.jpeg");

        List<Ingredient> hawaiianIngredients = new ArrayList<>(basicIngredients);
        hawaiianIngredients.addAll(Arrays.asList(ham, pineapple));
        Pizza hawaiianS = new Pizza("Hawaiian", PizzaSize.SMALL, new BigDecimal(24), hawaiianIngredients, basicSauces, "https://images.pexels.com/photos/1260968/pexels-photo-1260968.jpeg");
        Pizza hawaiianM = new Pizza("Hawaiian", PizzaSize.MEDIUM, new BigDecimal(32), hawaiianIngredients, basicSauces, "https://images.pexels.com/photos/1260968/pexels-photo-1260968.jpeg");
        Pizza hawaiianL = new Pizza("Hawaiian", PizzaSize.LARGE, new BigDecimal(40), hawaiianIngredients, basicSauces, "https://images.pexels.com/photos/1260968/pexels-photo-1260968.jpeg");

        List<Ingredient> farmerIngredients = new ArrayList<>(basicIngredients);
        farmerIngredients.addAll(Arrays.asList(chicken, bacon, greenPepper, redOnion));
        Pizza farmerS = new Pizza("Farmer", PizzaSize.SMALL, new BigDecimal(27), farmerIngredients, basicSauces, "https://images.pexels.com/photos/1260968/pexels-photo-1260968.jpeg");
        Pizza farmerM = new Pizza("Farmer", PizzaSize.MEDIUM, new BigDecimal(34), farmerIngredients, basicSauces, "https://images.pexels.com/photos/1260968/pexels-photo-1260968.jpeg");
        Pizza farmerL = new Pizza("Farmer", PizzaSize.LARGE, new BigDecimal(42), farmerIngredients, basicSauces, "https://images.pexels.com/photos/1260968/pexels-photo-1260968.jpeg");

        List<Ingredient> meatIngredients = new ArrayList<>(basicIngredients);
        meatIngredients.addAll(Arrays.asList(beef, bacon, pepperoni));
        Pizza meatS = new Pizza("Meat", PizzaSize.SMALL, new BigDecimal(28), meatIngredients, basicSauces, "https://images.pexels.com/photos/1260968/pexels-photo-1260968.jpeg");
        Pizza meatM = new Pizza("Meat", PizzaSize.MEDIUM, new BigDecimal(37), meatIngredients, basicSauces, "https://images.pexels.com/photos/1260968/pexels-photo-1260968.jpeg");
        Pizza meatL = new Pizza("Meat", PizzaSize.LARGE, new BigDecimal(45), meatIngredients, basicSauces, "https://images.pexels.com/photos/1260968/pexels-photo-1260968.jpeg");

        List<Ingredient> parmaIngredients = new ArrayList<>(basicIngredients);
        parmaIngredients.addAll(Arrays.asList(parmaHam, arugula, cherryTomatoes, parmesanCheese));
        Pizza parmaS = new Pizza("Parma", PizzaSize.SMALL, new BigDecimal(32), parmaIngredients, basicSauces, "https://images.pexels.com/photos/1260968/pexels-photo-1260968.jpeg");
        Pizza parmaM = new Pizza("Parma", PizzaSize.MEDIUM, new BigDecimal(39), parmaIngredients, basicSauces, "https://images.pexels.com/photos/1260968/pexels-photo-1260968.jpeg");
        Pizza parmaL = new Pizza("Parma", PizzaSize.LARGE, new BigDecimal(49), parmaIngredients, basicSauces, "https://images.pexels.com/photos/1260968/pexels-photo-1260968.jpeg");

        List<Pizza> allPizzas = new ArrayList<>(Arrays.asList(margheritaS, margheritaM, margheritaL, capricciosaS, capricciosaM, capricciosaL,
                pepperoniPizzaS, pepperoniPizzaM, pepperoniPizzaL, hawaiianS, hawaiianM,  hawaiianL, farmerS, farmerM, farmerL,
                meatS, meatM, meatL, parmaS, parmaM, parmaL));
        pizzaRepository.saveAll(allPizzas);






        UnregisteredUser unregisteredCustomer = new UnregisteredUser("unregistered", "unregistered", "unregistered","unregistered");
        RegisteredUser registeredJoe = new RegisteredUser("Joe", "Mama", "joemama@gmail.com", passwordEncoder.encode("mama"), Role.ROLE_USER, "111111111");
        userRepository.saveAll(Arrays.asList(unregisteredCustomer, registeredJoe));

        Address joesAddress1 = new Address(registeredJoe ,"Kraków", "11-111", "Zielona", "1", "1A");
        Address joesAddress2 = new Address(registeredJoe ,"Kraków", "22-222", "Czerwona", "2", "2B");
        addressRepository.saveAll(Arrays.asList(joesAddress1, joesAddress2));



        OrderCreateDTORegistered joesOrderRequest1 = new OrderCreateDTORegistered(2L, 1L, Arrays.asList(2L, 17L, 41L), new BigDecimal(61));
        OrderCreateDTORegistered joesOrderRequest2 = new OrderCreateDTORegistered(2L, 1L, Arrays.asList(26L), new BigDecimal(39));
        OrderCreateDTORegistered joesOrderRequest3 = new OrderCreateDTORegistered(2L, 2L, Arrays.asList(38L, 4L), new BigDecimal(53));
        orderService.createOrderForRegisteredCustomer(joesOrderRequest1);
        orderService.createOrderForRegisteredCustomer(joesOrderRequest2);
        orderService.createOrderForRegisteredCustomer(joesOrderRequest3);


        for (int i = 1; i <= 5; i++) {
            OrderCreateDTOUnregistered unregisteredCustomersOrderRequest = new OrderCreateDTOUnregistered("Unregistered", "User", "999999999", "unregistered@gmail.com" + i,
                    "Kraków", "99-999", "Czarna", "9", "9Z", Arrays.asList(34L, 13L), new BigDecimal(34));
            orderService.createOrderForUnregisteredCustomer(unregisteredCustomersOrderRequest);
        }




        RegisteredUser admin = new RegisteredUser("pulson", "pulson", "pulson", passwordEncoder.encode("pulson"), Role.ROLE_ADMIN, "1111111111");
        userRepository.save(admin);

        Address adminAddress = new Address(admin ,"f", "f", "f", "f", "f");
        addressRepository.save(adminAddress);


    }
}
