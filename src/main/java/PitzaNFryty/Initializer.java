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
import PitzaNFryty.order.Order;
import PitzaNFryty.order.OrderRepository;
import PitzaNFryty.payment.Payment;
import PitzaNFryty.payment.PaymentRepository;
import org.joda.money.Money;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class Initializer {
    public Initializer(DrinkRepository drinkRepository, FriesRepository friesRepository,
                       IngredientRepository ingredientRepository,
                       SauceRepository sauceRepository, PizzaRepository pizzaRepository,
                       PizzaSizeRepository pizzaSizeRepository, AddressRepository addressRepository,
                       PaymentRepository paymentRepository, OrderRepository orderRepository,
                       CustomerRepository customerRepository, MenuItemRepository menuItemRepository,
                       DrinkSizeRepository drinkSizeRepository) {

        DrinkSize smallDrinkSize = new DrinkSize("Small", new BigDecimal("0.5"));
        DrinkSize largeDrinkSize = new DrinkSize("Large", new BigDecimal(1));
        drinkSizeRepository.save(smallDrinkSize);
        drinkSizeRepository.save(largeDrinkSize);

        Drink smallCocaCola = new Drink("Small Coca-Cola", smallDrinkSize, new BigDecimal(5),"cocacolaurl");
        Drink largeCocaCola = new Drink("Large Coca-Cola", largeDrinkSize, new BigDecimal(8),"cocacolaurl");
        Drink smallPepsi = new Drink("Small Pepsi", smallDrinkSize, new BigDecimal(5),"pepsiurl");
        Drink largePepsi = new Drink("Large Pepsi", largeDrinkSize, new BigDecimal(8),"pepsiurl");
        Drink smallFanta = new Drink("Small Fanta", smallDrinkSize, new BigDecimal(5),"fantaurl");
        Drink largeFanta = new Drink("Large Fanta", largeDrinkSize, new BigDecimal(8),"fantaurl");
        Drink smallSprite = new Drink("Small Sprite", smallDrinkSize, new BigDecimal(5),"spriteurl");
        Drink largeSprite = new Drink("Large Sprite", largeDrinkSize, new BigDecimal(8),"spriteurl");
        Drink smallMirinda = new Drink("Small Mirinda", smallDrinkSize, new BigDecimal(5),"mirindaurl");
        Drink largeMirinda = new Drink("Large Mirinda", largeDrinkSize, new BigDecimal(8),"mirindaurl");
        Drink smallOrangeJuice = new Drink("Small Orange juice", smallDrinkSize, new BigDecimal(5),"orangejuiceurl");
        Drink largeOrangeJuice = new Drink("Large Orange juice", largeDrinkSize, new BigDecimal(8),"orangejuiceurl");
        Drink smallAppleJuice = new Drink("Small Apple juice", smallDrinkSize, new BigDecimal(5),"applejuiceurl");
        Drink largeAppleJuice = new Drink("Large Apple juice", largeDrinkSize, new BigDecimal(8),"applejuiceurl");
        drinkRepository.saveAll(Arrays.asList(smallCocaCola, largeCocaCola, smallPepsi, largePepsi, smallFanta, largeFanta,
               smallSprite, largeSprite, smallMirinda, largeMirinda, smallOrangeJuice, largeOrangeJuice, smallAppleJuice, largeAppleJuice));




//        Fries fries = new Fries("Fries", Stream.of(new FriesSize(FriesSizePrice.SMALL_FRIES), new FriesSize(FriesSizePrice.MEDIUM_FRIES), new FriesSize(FriesSizePrice.LARGE_FRIES)).collect(Collectors.toSet()), "friesurl");
//        friesRepository.save(fries);
//
//
//        Ingredient mozzarella = new Ingredient("Mozzarella cheese");
//        Ingredient tomatoSauce = new Ingredient("Tomato sauce");
//        Ingredient oregano = new Ingredient("Oregano");
//        Ingredient ham = new Ingredient("Ham");
//        Ingredient mushrooms = new Ingredient("Mushrooms");
//        Ingredient pineapple = new Ingredient("Pineapple");
//        Ingredient chicken = new Ingredient("Chicken");
//        Ingredient greenPepper = new Ingredient("Green pepper");
//        Ingredient redOnion = new Ingredient("Red onion");
//        Ingredient bacon = new Ingredient("Bacon");
//        Ingredient beef = new Ingredient("Beef");
//        Ingredient pepperoni = new Ingredient("Pepperoni");
//        Ingredient parmaHam = new Ingredient("Parma ham");
//        Ingredient cherryTomatoes = new Ingredient("Cherry tomatoes");
//        Ingredient arugula = new Ingredient("Arugula");
//        Ingredient parmesanCheese = new Ingredient("Parmesan cheese");
//        List<Ingredient> allIngredients = new ArrayList<>(Arrays.asList(mozzarella, tomatoSauce, oregano, ham, mushrooms, pineapple,
//                chicken, greenPepper, redOnion, bacon, beef, pepperoni, parmaHam, cherryTomatoes, arugula, parmesanCheese));
//        ingredientRepository.saveAll(allIngredients);
//        List<Ingredient> basicIngredients = Arrays.asList(mozzarella, tomatoSauce, oregano);
//
//
//        Sauce ketchup = new Sauce("Ketchup");
//        Sauce garlicSauce = new Sauce("Garlic sauce");
//        Sauce bbqSauce = new Sauce("BBQ sauce");
//        Sauce jalapenoSauce = new Sauce("Jalapeno sauce");
//        List<Sauce> allSauces = new ArrayList<>(Arrays.asList(ketchup, garlicSauce, bbqSauce, jalapenoSauce));
//        sauceRepository.saveAll(allSauces);
//        List<Sauce> basicSauces = Arrays.asList(ketchup, garlicSauce);
//
//
//        Set<PizzaSize> margheritaTypes = Stream.of(new PizzaSize(PizzaSizePrice.SMALL_MARGHERITA), new PizzaSize(PizzaSizePrice.MEDIUM_MARGHERITA), new PizzaSize(PizzaSizePrice.LARGE_MARGHERITA)).collect(Collectors.toSet());
//        Pizza margherita = new Pizza("Margherita", margheritaTypes, basicIngredients, basicSauces, "margheritaurl");
//
//        Set<PizzaSize> capricciosaTypes = Stream.of(new PizzaSize(PizzaSizePrice.SMALL_CAPRICCIOSA), new PizzaSize(PizzaSizePrice.MEDIUM_CAPRICCIOSA), new PizzaSize(PizzaSizePrice.LARGE_CAPRICCIOSA)).collect(Collectors.toSet());
//        List<Ingredient> capricciosaIngredients = new ArrayList<>(basicIngredients);
//        capricciosaIngredients.addAll(Arrays.asList(ham, mushrooms));
//        Pizza capricciosa = new Pizza("Capricciosa", capricciosaTypes, capricciosaIngredients, basicSauces, "capricciosaurl");
//
//        Set<PizzaSize> pepperoniTypes = Stream.of(new PizzaSize(PizzaSizePrice.SMALL_PEPPERONI), new PizzaSize(PizzaSizePrice.MEDIUM_PEPPERONI), new PizzaSize(PizzaSizePrice.LARGE_PEPPERONI)).collect(Collectors.toSet());
//        List<Ingredient> pepperoniIngredients = new ArrayList<>(basicIngredients);
//        pepperoniIngredients.addAll(Arrays.asList(pepperoni));
//        Pizza pepperoniPizza = new Pizza("Pepperoni", pepperoniTypes, pepperoniIngredients, basicSauces, "pepperoniurl");
//
//        Set<PizzaSize> hawaiianTypes = Stream.of(new PizzaSize(PizzaSizePrice.SMALL_HAWAIIAN), new PizzaSize(PizzaSizePrice.MEDIUM_HAWAIIAN), new PizzaSize(PizzaSizePrice.LARGE_HAWAIIAN)).collect(Collectors.toSet());
//        List<Ingredient> hawaiianIngredients = new ArrayList<>(basicIngredients);
//        hawaiianIngredients.addAll(Arrays.asList(ham, pineapple));
//        Pizza hawaiian = new Pizza("Hawaiian", hawaiianTypes, hawaiianIngredients, basicSauces, "hawaiianurl");
//
//        Set<PizzaSize> farmerTypes = Stream.of(new PizzaSize(PizzaSizePrice.SMALL_FARMER), new PizzaSize(PizzaSizePrice.MEDIUM_FARMER), new PizzaSize(PizzaSizePrice.LARGE_FARMER)).collect(Collectors.toSet());
//        List<Ingredient> farmerIngredients = new ArrayList<>(basicIngredients);
//        farmerIngredients.addAll(Arrays.asList(chicken, bacon, greenPepper, redOnion));
//        Pizza farmer = new Pizza("Farmer", farmerTypes, farmerIngredients, basicSauces, "farmerurl");
//
//        Set<PizzaSize> meatTypes = Stream.of(new PizzaSize(PizzaSizePrice.SMALL_MEAT), new PizzaSize(PizzaSizePrice.MEDIUM_MEAT), new PizzaSize(PizzaSizePrice.LARGE_MEAT)).collect(Collectors.toSet());
//        List<Ingredient> meatIngredients = new ArrayList<>(basicIngredients);
//        meatIngredients.addAll(Arrays.asList(beef, bacon, pepperoni));
//        Pizza meat = new Pizza("Meat", meatTypes, meatIngredients, basicSauces, "meaturl");
//
//        Set<PizzaSize> parmaTypes = Stream.of(new PizzaSize(PizzaSizePrice.SMALL_PARMA), new PizzaSize(PizzaSizePrice.MEDIUM_PARMA), new PizzaSize(PizzaSizePrice.LARGE_PARMA)).collect(Collectors.toSet());
//        List<Ingredient> parmaIngredients = new ArrayList<>(basicIngredients);
//        parmaIngredients.addAll(Arrays.asList(parmaHam, arugula, cherryTomatoes, parmesanCheese));
//        Pizza parma = new Pizza("Parma", parmaTypes, parmaIngredients, basicSauces, "parmanurl");
//
//        List<Pizza> allPizzas = new ArrayList<>(Arrays.asList(margherita, capricciosa, pepperoniPizza, hawaiian, farmer, meat, parma));
//        pizzaRepository.saveAll(allPizzas);


//        Address address1 = new Address("Kraków", "11-111", "Zielona", "1", "1A");
//        Address address2 = new Address("Kraków", "33-333", "Czerwona", "2", "2B");
//
//        Customer customerJoe = new Customer("Joe", "Mama", 111111111, Stream.of(address1, address2).collect(Collectors.toSet()), new HashSet<>());
//        Payment payment1 = new Payment(customerJoe, Money.parse("PLN 92.00"), LocalDateTime.now().minusHours(1));
//        Payment payment2 = new Payment(customerJoe, Money.parse("PLN 40.00"), LocalDateTime.now());
//        Order order1 = new Order(customerJoe, address1, (menuItemRepository.findAllByNameInIgnoreCase(Arrays.asList("small pepsi"))), payment1, LocalDateTime.now(), LocalDateTime.now().plusMinutes(30));
        //Order order3 = new Order(customerJoe, address1, Arrays.asList(menuItemRepository.findByNameContainingIgnoreCase("small pepsi")), payment1, LocalDateTime.now(), LocalDateTime.now().plusMinutes(30));

        //Order order2 = new Order(customerJoe, address1, Arrays.asList(drinkRepository.findDrinkByDrinkSize(drinkSizeRepository.findDrinkSizeBySizePriceIsLike(DrinkSizePrice.LARGE_PEPSI))), payment2, LocalDateTime.now(), LocalDateTime.now().plusMinutes(30));


       //System.out.println(drinkRepository.findDrinkByDrinkSize(drinkSizeRepository.findDrinkSizeBySizePriceIsLike(DrinkSizePrice.LARGE_PEPSI)));
//        System.out.println(drinkRepository.findDrinkByDrinkSize(drinkSizeRepository.findDrinkSizeBySizePriceIsLike(DrinkSizePrice.LARGE_PEPSI)));
//        System.out.println(drinkRepository.findDrinkByDrinkSize(drinkSizeRepository.findDrinkSizeBySizePriceIsLike(DrinkSizePrice.LARGE_PEPSI)));
//        System.out.println(drinkRepository.findDrinkByDrinkSize(drinkSizeRepository.findDrinkSizeBySizePriceIsLike(DrinkSizePrice.LARGE_PEPSI)));
//
//        customerJoe.setOrders(Stream.of(order1).collect(Collectors.toSet()));
//        customerRepository.save(customerJoe);

    }
}
