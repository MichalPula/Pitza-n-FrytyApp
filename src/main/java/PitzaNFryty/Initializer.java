package PitzaNFryty;

import PitzaNFryty.menu_item.drink.*;
import PitzaNFryty.menu_item.fries.Fries;
import PitzaNFryty.menu_item.fries.FriesRepository;
import PitzaNFryty.menu_item.fries.FriesSize;
import PitzaNFryty.menu_item.fries.FriesSizeRepository;
import PitzaNFryty.menu_item.ingredient.Ingredient;
import PitzaNFryty.menu_item.ingredient.IngredientRepository;
import PitzaNFryty.menu_item.pizza.*;
import PitzaNFryty.menu_item.sauce.Sauce;
import PitzaNFryty.menu_item.sauce.SauceRepository;
import PitzaNFryty.order.Order;
import PitzaNFryty.order.OrderRepository;
import PitzaNFryty.payment.Payment;
import PitzaNFryty.payment.PaymentRepository;
import org.joda.money.Money;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class Initializer {
    public Initializer(DrinkRepository drinkRepository, FriesRepository friesRepository,
                       IngredientRepository ingredientRepository, FriesSizeRepository friesSizeRepository,
                       SauceRepository sauceRepository, PizzaRepository pizzaRepository,
                       PizzaSizeRepository pizzaSizeRepository, AddressRepository addressRepository,
                       PaymentRepository paymentRepository, OrderRepository orderRepository,
                       CustomerRepository customerRepository, MenuItemRepository menuItemRepository,
                       DrinkSizeRepository drinkSizeRepository) {

        DrinkSize smallDrinkSize = new DrinkSize("Small", new BigDecimal("0.5"));
        DrinkSize largeDrinkSize = new DrinkSize("Large", new BigDecimal(1));
        drinkSizeRepository.saveAll(Arrays.asList(smallDrinkSize, largeDrinkSize));

        Drink cocaColaS = new Drink("Coca-Cola", smallDrinkSize, new BigDecimal(5),"cocacolaurl");
        Drink cocaColaL = new Drink("Coca-Cola", largeDrinkSize, new BigDecimal(8),"cocacolaurl");
        Drink pepsiS = new Drink("Pepsi", smallDrinkSize, new BigDecimal(5),"pepsiurl");
        Drink pepsiL = new Drink("Pepsi", largeDrinkSize, new BigDecimal(8),"pepsiurl");
        Drink fantaS = new Drink("Fanta", smallDrinkSize, new BigDecimal(5),"fantaurl");
        Drink fantaL = new Drink("Fanta", largeDrinkSize, new BigDecimal(8),"fantaurl");
        Drink spriteS = new Drink("Sprite", smallDrinkSize, new BigDecimal(5),"spriteurl");
        Drink spriteL = new Drink("Sprite", largeDrinkSize, new BigDecimal(8),"spriteurl");
        Drink mirindaS = new Drink("Mirinda", smallDrinkSize, new BigDecimal(5),"mirindaurl");
        Drink mirindaL = new Drink("Mirinda", largeDrinkSize, new BigDecimal(8),"mirindaurl");
        Drink orangeJuiceS = new Drink("Orange juice", smallDrinkSize, new BigDecimal(5),"orangejuiceurl");
        Drink orangeJuiceL = new Drink("Orange juice", largeDrinkSize, new BigDecimal(8),"orangejuiceurl");
        Drink appleJuiceS = new Drink("Apple juice", smallDrinkSize, new BigDecimal(5),"applejuiceurl");
        Drink appleJuiceL = new Drink("Apple juice", largeDrinkSize, new BigDecimal(8),"applejuiceurl");
        drinkRepository.saveAll(Arrays.asList(cocaColaS, cocaColaL, pepsiS, pepsiL, fantaS, fantaL,
                spriteS, spriteL, mirindaS, mirindaL, orangeJuiceS, orangeJuiceL, appleJuiceS, appleJuiceL));


        FriesSize smallFriesSize = new FriesSize("Small");
        FriesSize mediumFriesSize = new FriesSize("Medium");
        FriesSize largeFriesSize = new FriesSize("Large");
        friesSizeRepository.saveAll(Arrays.asList(smallFriesSize, mediumFriesSize, largeFriesSize));

        Fries smallFries = new Fries("Fries", smallFriesSize, new BigDecimal(3), "friesurl");
        Fries mediumFries = new Fries("Fries", mediumFriesSize, new BigDecimal(4), "friesurl");
        Fries largeFries =new Fries("Fries", largeFriesSize, new BigDecimal(5), "friesurl");
        Fries cheeseFries =new Fries("Cheese Fries", largeFriesSize, new BigDecimal(8), "cheesefriesurl");
        friesRepository.saveAll(Arrays.asList(smallFries, mediumFries, largeFries, cheeseFries));


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


        PizzaSize smallPizzaSize = new PizzaSize("Small", 30);
        PizzaSize mediumPizzaSize = new PizzaSize("Medium", 40);
        PizzaSize largePizzaSize = new PizzaSize("Large", 50);
        pizzaSizeRepository.saveAll(Arrays.asList(smallPizzaSize, mediumPizzaSize, largePizzaSize));

        Pizza margheritaS = new Pizza("Margherita", smallPizzaSize, new BigDecimal(21), basicIngredients, basicSauces, "margheritaurl");
        Pizza margheritaM = new Pizza("Margherita", mediumPizzaSize, new BigDecimal(28), basicIngredients, basicSauces, "margheritaurl");
        Pizza margheritaL = new Pizza("Margherita", largePizzaSize, new BigDecimal(32), basicIngredients, basicSauces, "margheritaurl");

        List<Ingredient> capricciosaIngredients = new ArrayList<>(basicIngredients);
        capricciosaIngredients.addAll(Arrays.asList(ham, mushrooms));
        Pizza capricciosaS = new Pizza("Capricciosa", smallPizzaSize, new BigDecimal(25), capricciosaIngredients, basicSauces, "capricciosaurl");
        Pizza capricciosaM = new Pizza("Capricciosa", mediumPizzaSize, new BigDecimal(31), capricciosaIngredients, basicSauces, "capricciosaurl");
        Pizza capricciosaL = new Pizza("Capricciosa", largePizzaSize, new BigDecimal(39), capricciosaIngredients, basicSauces, "capricciosaurl");

        List<Ingredient> pepperoniIngredients = new ArrayList<>(basicIngredients);
        pepperoniIngredients.addAll(Arrays.asList(pepperoni));
        Pizza pepperoniPizzaS = new Pizza("Pepperoni", smallPizzaSize, new BigDecimal(23), pepperoniIngredients, basicSauces, "pepperoniurl");
        Pizza pepperoniPizzaM = new Pizza("Pepperoni", mediumPizzaSize, new BigDecimal(30), pepperoniIngredients, basicSauces, "pepperoniurl");
        Pizza pepperoniPizzaL = new Pizza("Pepperoni", largePizzaSize, new BigDecimal(37), pepperoniIngredients, basicSauces, "pepperoniurl");

        List<Ingredient> hawaiianIngredients = new ArrayList<>(basicIngredients);
        hawaiianIngredients.addAll(Arrays.asList(ham, pineapple));
        Pizza hawaiianS = new Pizza("Hawaiian", smallPizzaSize, new BigDecimal(24), hawaiianIngredients, basicSauces, "hawaiianurl");
        Pizza hawaiianM = new Pizza("Hawaiian", mediumPizzaSize, new BigDecimal(32), hawaiianIngredients, basicSauces, "hawaiianurl");
        Pizza hawaiianL = new Pizza("Hawaiian", largePizzaSize, new BigDecimal(40), hawaiianIngredients, basicSauces, "hawaiianurl");

        List<Ingredient> farmerIngredients = new ArrayList<>(basicIngredients);
        farmerIngredients.addAll(Arrays.asList(chicken, bacon, greenPepper, redOnion));
        Pizza farmerS = new Pizza("Farmer", smallPizzaSize, new BigDecimal(27), farmerIngredients, basicSauces, "farmerurl");
        Pizza farmerM = new Pizza("Farmer", mediumPizzaSize, new BigDecimal(34), farmerIngredients, basicSauces, "farmerurl");
        Pizza farmerL = new Pizza("Farmer", largePizzaSize, new BigDecimal(42), farmerIngredients, basicSauces, "farmerurl");

        List<Ingredient> meatIngredients = new ArrayList<>(basicIngredients);
        meatIngredients.addAll(Arrays.asList(beef, bacon, pepperoni));
        Pizza meatS = new Pizza("Meat", smallPizzaSize, new BigDecimal(28), meatIngredients, basicSauces, "meaturl");
        Pizza meatM = new Pizza("Meat", mediumPizzaSize, new BigDecimal(37), meatIngredients, basicSauces, "meaturl");
        Pizza meatL = new Pizza("Meat", largePizzaSize, new BigDecimal(45), meatIngredients, basicSauces, "meaturl");

        List<Ingredient> parmaIngredients = new ArrayList<>(basicIngredients);
        parmaIngredients.addAll(Arrays.asList(parmaHam, arugula, cherryTomatoes, parmesanCheese));
        Pizza parmaS = new Pizza("Parma", smallPizzaSize, new BigDecimal(32), parmaIngredients, basicSauces, "parmanurl");
        Pizza parmaM = new Pizza("Parma", mediumPizzaSize, new BigDecimal(39), parmaIngredients, basicSauces, "parmanurl");
        Pizza parmaL = new Pizza("Parma", largePizzaSize, new BigDecimal(49), parmaIngredients, basicSauces, "parmanurl");

        List<Pizza> allPizzas = new ArrayList<>(Arrays.asList(margheritaS, margheritaM, margheritaL, capricciosaS, capricciosaM, capricciosaL,
                pepperoniPizzaS, pepperoniPizzaM, pepperoniPizzaL, hawaiianS, hawaiianM,  hawaiianL, farmerS, farmerM, farmerL,
                meatS, meatM, meatL, parmaS, parmaM, parmaL));
        pizzaRepository.saveAll(allPizzas);


        Address address1 = new Address("Kraków", "11-111", "Zielona", "1", "1A");
        Address address2 = new Address("Kraków", "33-333", "Czerwona", "2", "2B");

        Customer customerJoe = new Customer("Joe", "Mama", 111111111, Stream.of(address1, address2).collect(Collectors.toSet()), new HashSet<>());

        Order order1 = new Order(customerJoe, address1, Arrays.asList(parmaS, meatS, pepsiL), new Payment(customerJoe, new BigDecimal(60), LocalDateTime.now()), LocalDateTime.now(), LocalDateTime.now().plusMinutes(30));
        Order order2 = new Order(customerJoe, address2, Arrays.asList(hawaiianL, cheeseFries, fantaS), new Payment(customerJoe, new BigDecimal(40), LocalDateTime.now()), LocalDateTime.now(), LocalDateTime.now().plusMinutes(30));

        customerJoe.setOrders(Stream.of(order1, order2).collect(Collectors.toSet()));
        customerRepository.save(customerJoe);
    }
}
