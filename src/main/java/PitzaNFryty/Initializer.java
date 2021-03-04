package PitzaNFryty;

import PitzaNFryty.menu_item.drink.*;
import PitzaNFryty.menu_item.fries.Fries;
import PitzaNFryty.menu_item.fries.FriesRepository;
import PitzaNFryty.menu_item.fries.FriesSize;
import PitzaNFryty.menu_item.fries.FriesSizePrice;
import PitzaNFryty.menu_item.ingredient.Ingredient;
import PitzaNFryty.menu_item.ingredient.IngredientRepository;
import PitzaNFryty.menu_item.pizza.*;
import PitzaNFryty.menu_item.sauce.Sauce;
import PitzaNFryty.menu_item.sauce.SauceRepository;
import PitzaNFryty.order.OrderRepository;
import PitzaNFryty.payment.Payment;
import PitzaNFryty.payment.PaymentRepository;
import org.joda.money.Money;
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


        friesRepository.save(new Fries("Fries", Stream.of(new FriesSize(FriesSizePrice.SMALL_FRIES), new FriesSize(FriesSizePrice.MEDIUM_FRIES), new FriesSize(FriesSizePrice.LARGE_FRIES)).collect(Collectors.toSet()), "friesurl"));


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
        List<Ingredient> allIngredients = new ArrayList<>(Arrays.asList(mozzarella, tomatoSauce, oregano, ham, mushrooms, pineapple,
                chicken, greenPepper, redOnion, bacon, beef, pepperoni, parmaHam, cherryTomatoes, arugula, parmesanCheese));
        ingredientRepository.saveAll(allIngredients);
        List<Ingredient> basicIngredients = Arrays.asList(mozzarella, tomatoSauce, oregano);


        Sauce ketchup = new Sauce("Ketchup");
        Sauce garlicSauce = new Sauce("Garlic sauce");
        Sauce bbqSauce = new Sauce("BBQ sauce");
        Sauce jalapenoSauce = new Sauce("Jalapeno sauce");
        List<Sauce> allSauces = new ArrayList<>(Arrays.asList(ketchup, garlicSauce, bbqSauce, jalapenoSauce));
        sauceRepository.saveAll(allSauces);
        List<Sauce> basicSauces = Arrays.asList(ketchup, garlicSauce);


        Set<PizzaSize> margheritaTypes = Stream.of(new PizzaSize(PizzaSizePrice.SMALL_MARGHERITA), new PizzaSize(PizzaSizePrice.MEDIUM_MARGHERITA), new PizzaSize(PizzaSizePrice.LARGE_MARGHERITA)).collect(Collectors.toSet());
        pizzaRepository.save(new Pizza("Margherita", margheritaTypes, basicIngredients, basicSauces, "margheritaurl"));

        Set<PizzaSize> capricciosaTypes = Stream.of(new PizzaSize(PizzaSizePrice.SMALL_CAPRICCIOSA), new PizzaSize(PizzaSizePrice.MEDIUM_CAPRICCIOSA), new PizzaSize(PizzaSizePrice.LARGE_CAPRICCIOSA)).collect(Collectors.toSet());
        List<Ingredient> capricciosaIngredients = new ArrayList<>(basicIngredients);
        capricciosaIngredients.addAll(Arrays.asList(ham, mushrooms));
        pizzaRepository.save(new Pizza("Capricciosa", capricciosaTypes, capricciosaIngredients, basicSauces, "capricciosaurl"));

        Set<PizzaSize> pepperoniTypes = Stream.of(new PizzaSize(PizzaSizePrice.SMALL_PEPPERONI), new PizzaSize(PizzaSizePrice.MEDIUM_PEPPERONI), new PizzaSize(PizzaSizePrice.LARGE_PEPPERONI)).collect(Collectors.toSet());
        List<Ingredient> pepperoniIngredients = new ArrayList<>(basicIngredients);
        pepperoniIngredients.addAll(Arrays.asList(pepperoni));
        pizzaRepository.save(new Pizza("Pepperoni", pepperoniTypes, pepperoniIngredients, basicSauces, "pepperoniurl"));

        Set<PizzaSize> hawaiianTypes = Stream.of(new PizzaSize(PizzaSizePrice.SMALL_HAWAIIAN), new PizzaSize(PizzaSizePrice.MEDIUM_HAWAIIAN), new PizzaSize(PizzaSizePrice.LARGE_HAWAIIAN)).collect(Collectors.toSet());
        List<Ingredient> hawaiianIngredients = new ArrayList<>(basicIngredients);
        hawaiianIngredients.addAll(Arrays.asList(ham, pineapple));
        pizzaRepository.save(new Pizza("Hawaiian", hawaiianTypes, hawaiianIngredients, basicSauces, "hawaiianurl"));

        Set<PizzaSize> farmerTypes = Stream.of(new PizzaSize(PizzaSizePrice.SMALL_FARMER), new PizzaSize(PizzaSizePrice.MEDIUM_FARMER), new PizzaSize(PizzaSizePrice.LARGE_FARMER)).collect(Collectors.toSet());
        List<Ingredient> farmerIngredients = new ArrayList<>(basicIngredients);
        farmerIngredients.addAll(Arrays.asList(chicken, bacon, greenPepper, redOnion));
        pizzaRepository.save(new Pizza("Farmer", farmerTypes, farmerIngredients, basicSauces, "farmerurl"));

        Set<PizzaSize> meatTypes = Stream.of(new PizzaSize(PizzaSizePrice.SMALL_MEAT), new PizzaSize(PizzaSizePrice.MEDIUM_MEAT), new PizzaSize(PizzaSizePrice.LARGE_MEAT)).collect(Collectors.toSet());
        List<Ingredient> meatIngredients = new ArrayList<>(basicIngredients);
        meatIngredients.addAll(Arrays.asList(beef, bacon, pepperoni));
        pizzaRepository.save(new Pizza("Meat", meatTypes, meatIngredients, basicSauces, "meaturl"));

        Set<PizzaSize> parmaTypes = Stream.of(new PizzaSize(PizzaSizePrice.SMALL_PARMA), new PizzaSize(PizzaSizePrice.MEDIUM_PARMA), new PizzaSize(PizzaSizePrice.LARGE_PARMA)).collect(Collectors.toSet());
        List<Ingredient> parmaIngredients = new ArrayList<>(basicIngredients);
        parmaIngredients.addAll(Arrays.asList(parmaHam, arugula, cherryTomatoes, parmesanCheese));
        pizzaRepository.save(new Pizza("Parma", parmaTypes, parmaIngredients, basicSauces, "parmanurl"));








        Address address1 = new Address("Kraków", "11-111", "Zielona", "1", "1A");
        Address address2 = new Address("Kraków", "33-333", "Czerwona", "2", "2B");

        //Customer customerJoe = new Customer("Joe", "Mama", 222222222, Stream.of(address1, address2).collect(Collectors.toSet()),null);

        //Payment payment1 = new Payment(customerJoe, Money.parse("PLN 55.99"), LocalDateTime.now().minusHours(1));
        //Payment payment2 = new Payment(customerJoe, Money.parse("PLN 28.99"), LocalDateTime.now());

        //Order order2 = new Order(customerJoe, address2, Arrays.asList(capricciosa), payment2, LocalDateTime.now(), LocalDateTime.now().plusMinutes(30));
        //customerJoe.setOrders(Stream.of(order1).collect(Collectors.toSet()));

        //Customer customerJoe = new Customer("Joe", "Mama", 111111111, Stream.of(address1, address2).collect(Collectors.toSet()),null);
        //Order order1 = new Order(customerJoe, address1, Arrays.asList(margherita, capricciosa),  payment1, LocalDateTime.now(), LocalDateTime.now().plusMinutes(30));
        //customerRepository.save(customerJoe);
    }
}
