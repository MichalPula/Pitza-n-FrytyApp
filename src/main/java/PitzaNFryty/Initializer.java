package PitzaNFryty;

import PitzaNFryty.menu_item.drink.*;
import PitzaNFryty.menu_item.fries.Fries;
import PitzaNFryty.menu_item.fries.FriesRepository;
import PitzaNFryty.menu_item.ingredient.Ingredient;
import PitzaNFryty.menu_item.ingredient.IngredientRepository;
import PitzaNFryty.menu_item.pizza.*;
import PitzaNFryty.menu_item.sauce.Sauce;
import PitzaNFryty.menu_item.sauce.SauceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class Initializer {
    public Initializer(DrinkRepository drinkRepository, FriesRepository friesRepository,
                       DrinkTypeRepository drinkTypeRepository, IngredientRepository ingredientRepository,
                       SauceRepository sauceRepository, PizzaRepository pizzaRepository,
                       PizzaTypeRepository pizzaTypeRepository, AddressRepository addressRepository,
                       PaymentRepository paymentRepository, OrderRepository orderRepository,
                       CustomerRepository customerRepository, MenuItemRepository menuItemRepository){



        drinkRepository.save(new Drink("Coca-Cola", Stream.of(new DrinkSize(DrinkSizePrice.SMALL_COLA), new DrinkSize(DrinkSizePrice.MEDIUM_COLA), new DrinkSize(DrinkSizePrice.LARGE_COLA)).collect(Collectors.toSet()), "cocacolaurl"));
        drinkRepository.save(new Drink("Pepsi", Stream.of(new DrinkSize(DrinkSizePrice.SMALL_PEPSI), new DrinkSize(DrinkSizePrice.MEDIUM_PEPSI), new DrinkSize(DrinkSizePrice.LARGE_PEPSI)).collect(Collectors.toSet()), "pepsiurl"));
        drinkRepository.save(new Drink("Fanta", Stream.of(new DrinkSize(DrinkSizePrice.SMALL_FANTA), new DrinkSize(DrinkSizePrice.MEDIUM_FANTA), new DrinkSize(DrinkSizePrice.LARGE_FANTA)).collect(Collectors.toSet()),  "fantaurl"));
        drinkRepository.save(new Drink("Sprite", Stream.of(new DrinkSize(DrinkSizePrice.SMALL_SPRITE), new DrinkSize(DrinkSizePrice.MEDIUM_SPRITE), new DrinkSize(DrinkSizePrice.LARGE_SPRITE)).collect(Collectors.toSet()), "spriteurl"));
        drinkRepository.save(new Drink("Mirinda", Stream.of(new DrinkSize(DrinkSizePrice.SMALL_MIRINDA), new DrinkSize(DrinkSizePrice.MEDIUM_MIRINDA), new DrinkSize(DrinkSizePrice.LARGE_MIRINDA)).collect(Collectors.toSet()), "mirindaurl"));
        drinkRepository.save(new Drink("Orange juice", Stream.of(new DrinkSize(DrinkSizePrice.SMALL_ORANGE_JUICE), new DrinkSize(DrinkSizePrice.MEDIUM_ORANGE_JUICE), new DrinkSize(DrinkSizePrice.LARGE_ORANGE_JUICE)).collect(Collectors.toSet()), "orangejuiceurl"));
        drinkRepository.save(new Drink("Apple juice", Stream.of(new DrinkSize(DrinkSizePrice.SMALL_APPLE_JUICE), new DrinkSize(DrinkSizePrice.MEDIUM_APPLE_JUICE), new DrinkSize(DrinkSizePrice.LARGE_APPLE_JUICE)).collect(Collectors.toSet()), "applejuiceurl"));

//        friesRepository.save(new Fries("Small fries", 2, "smallfriesurl"));
//        friesRepository.save(new Fries("Medium fries", 3, "mediumfriesurl"));
//        friesRepository.save(new Fries("Large fries", 5, "largefriesurl"));
//
//        Arrays.stream(PizzaSizePrice.values()).forEach(pizzaSizePrice -> {
//            PizzaType pizzaType = new PizzaType(pizzaSizePrice);
//            pizzaTypeRepository.save(pizzaType);
//        });
//
//        ingredientRepository.save(new Ingredient("Mozzarella cheese"));
//        ingredientRepository.save(new Ingredient("Tomato sauce"));
//        ingredientRepository.save(new Ingredient("Oregano"));
//        ingredientRepository.save(new Ingredient("Ham"));
//        ingredientRepository.save(new Ingredient("Mushrooms"));
//
//        sauceRepository.save(new Sauce("Ketchup"));
//        sauceRepository.save(new Sauce("Garlic sauce"));
//        sauceRepository.save(new Sauce("BBQ sauce"));
//        sauceRepository.save(new Sauce("Jalapeno sauce"));
//
//        List<Ingredient> basicIngredients = new ArrayList<>(ingredientRepository.findIngredientsByNameIn(new ArrayList<>(Arrays.asList("Mozzarella cheese", "Tomato sauce", "Oregano"))));
//        List<Sauce> basicSauces = new ArrayList<>(sauceRepository.findSaucesByNameIn(new ArrayList<>(Arrays.asList("Ketchup" , "Garlic sauce"))));
//
//        Set<PizzaType> margheritaTypes = new HashSet<>(pizzaTypeRepository.findPizzaTypesBySizePriceIn(Arrays.asList(PizzaSizePrice.SMALL_MARGHERITA, PizzaSizePrice.MEDIUM_MARGHERITA, PizzaSizePrice.LARGE_MARGHERITA)));
//        Pizza margherita = new Pizza("Margherita", margheritaTypes, basicIngredients, basicSauces, "margheritaurl");
//        //pizzaRepository.save();
//
//        Set<PizzaType> capricciosaTypes = new HashSet<>(pizzaTypeRepository.findPizzaTypesBySizePriceIn(Arrays.asList(PizzaSizePrice.SMALL_CAPRICCIOSA, PizzaSizePrice.MEDIUM_CAPRICCIOSA, PizzaSizePrice.LARGE_CAPRICCIOSA)));
//        List<Ingredient> capricciosaIngredients = new ArrayList<>();
//        capricciosaIngredients.addAll(basicIngredients);
//        capricciosaIngredients.addAll(new ArrayList<>(Arrays.asList(ingredientRepository.findIngredientByName("Ham"), ingredientRepository.findIngredientByName("Mushrooms"))));
//        //pizzaRepository.save();
//        Pizza capricciosa = new Pizza("Capricciosa", capricciosaTypes, capricciosaIngredients, basicSauces, "capricciosaurl");
//
//
//        Address address1 = new Address("Kraków", "22-222", "Zielona", "23", "1A");
//        Address address2 = new Address("Kraków", "33-333", "Czerwona", "11", "5");
//        Customer customerJoe = new Customer("Joe", "Mama", 12345689, Stream.of(address1, address2).collect(Collectors.toSet()),null);
//
//        Payment payment1 = new Payment(customerJoe, Money.parse("PLN 55.99"), LocalDateTime.now().minusHours(1));
//        Payment payment2 = new Payment(customerJoe, Money.parse("PLN 28.99"), LocalDateTime.now());
//        Order order1 = new Order(customerJoe, address1, Arrays.asList(margherita, capricciosa),  payment1, LocalDateTime.now(), LocalDateTime.now().plusMinutes(30));
//        //Order order2 = new Order(customerJoe, address2, Arrays.asList(capricciosa), payment2, LocalDateTime.now(), LocalDateTime.now().plusMinutes(30));
//        customerJoe.setOrders(Stream.of(order1).collect(Collectors.toSet()));
//
//
//        customerRepository.save(customerJoe);
    }
}
