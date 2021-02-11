package PitzaNFryty;

import PitzaNFryty.menu_item.drink.*;
import PitzaNFryty.menu_item.fries.Fries;
import PitzaNFryty.menu_item.fries.FriesRepository;
import PitzaNFryty.menu_item.ingredient.Ingredient;
import PitzaNFryty.menu_item.ingredient.IngredientRepository;
import PitzaNFryty.menu_item.sauce.Sauce;
import PitzaNFryty.menu_item.sauce.SauceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class Initializer {
    public Initializer(DrinkRepository drinkRepository, FriesRepository friesRepository,
                       DrinkTypeRepository drinkTypeRepository, IngredientRepository ingredientRepository,
                       SauceRepository sauceRepository){

        Arrays.stream(DrinkSizePrice.values()).forEach(drinkSizePrice -> {
            DrinkSize drinkSize = new DrinkSize(drinkSizePrice);
            drinkTypeRepository.save(drinkSize);
        });

        drinkRepository.save(new Drink("Coca-Cola",
                drinkTypeRepository.findDrinkTypesBySizePriceIn(new ArrayList<>(Arrays.asList(DrinkSizePrice.SMALL_COLA, DrinkSizePrice.MEDIUM_COLA, DrinkSizePrice.LARGE_COLA))), "cocacolaurl"));
        drinkRepository.save(new Drink("Pepsi",
                drinkTypeRepository.findDrinkTypesBySizePriceIn(new ArrayList<>(Arrays.asList(DrinkSizePrice.SMALL_PEPSI, DrinkSizePrice.MEDIUM_PEPSI, DrinkSizePrice.LARGE_PEPSI))), "pepsiurl"));
        drinkRepository.save(new Drink("Fanta",
                drinkTypeRepository.findDrinkTypesBySizePriceIn(new ArrayList<>(Arrays.asList(DrinkSizePrice.SMALL_FANTA, DrinkSizePrice.MEDIUM_FANTA, DrinkSizePrice.LARGE_FANTA))),  "fantaurl"));
        drinkRepository.save(new Drink("Sprite",
                drinkTypeRepository.findDrinkTypesBySizePriceIn(new ArrayList<>(Arrays.asList(DrinkSizePrice.SMALL_SPRITE, DrinkSizePrice.MEDIUM_SPRITE ,DrinkSizePrice.LARGE_SPRITE))), "spriteurl"));
        drinkRepository.save(new Drink("Orange juice",
               drinkTypeRepository.findDrinkTypesBySizePriceIn(new ArrayList<>(Arrays.asList(DrinkSizePrice.SMALL_ORANGE_JUICE, DrinkSizePrice.MEDIUM_ORANGE_JUICE ,DrinkSizePrice.LARGE_ORANGE_JUICE))), "orangejuiceurl"));
        drinkRepository.save(new Drink("Apple juice",
                    drinkTypeRepository.findDrinkTypesBySizePriceIn(new ArrayList<>(Arrays.asList(DrinkSizePrice.SMALL_APPLE_JUICE, DrinkSizePrice.MEDIUM_APPLE_JUICE ,DrinkSizePrice.LARGE_APPLE_JUICE))), "applejuiceurl"));

        friesRepository.save(new Fries("Small fries", 2, "smallfriesurl"));
        friesRepository.save(new Fries("Medium fries", 3, "mediumfriesurl"));
        friesRepository.save(new Fries("Large fries", 5, "largefriesurl"));

        ingredientRepository.save(new Ingredient("Mozzarella cheese"));
        ingredientRepository.save(new Ingredient("Tomato sauce"));
        ingredientRepository.save(new Ingredient("Oregano"));
        ingredientRepository.save(new Ingredient("Ham"));
        ingredientRepository.save(new Ingredient("Mushrooms"));

        sauceRepository.save(new Sauce("Garlic sauce"));
        sauceRepository.save(new Sauce("Tomato sauce"));
        sauceRepository.save(new Sauce("BBQ sauce"));
        sauceRepository.save(new Sauce("Jalapeno sauce"));
    }
}
