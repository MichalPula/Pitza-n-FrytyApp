package PitzaNFryty;

import PitzaNFryty.menu_item.drink.*;
import PitzaNFryty.menu_item.fries.Fries;
import PitzaNFryty.menu_item.fries.FriesRepository;
import PitzaNFryty.menu_item.ingredient.Ingredient;
import PitzaNFryty.menu_item.ingredient.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class Initializer {
    public Initializer(DrinkRepository drinkRepository, FriesRepository friesRepository,
                       DrinkTypeRepository drinkTypeRepository, IngredientRepository ingredientRepository){

        Arrays.stream(DrinkSizePrice.values()).forEach(drinkSizePrice -> {
            DrinkSize drinkSize = new DrinkSize(drinkSizePrice);
            drinkTypeRepository.save(drinkSize);
        });

        drinkRepository.save(new Drink("Coca-Cola",
                drinkTypeRepository.findDrinkTypesBySizePriceIn(new ArrayList<>(Arrays.asList(DrinkSizePrice.SMALL_COLA, DrinkSizePrice.MEDIUM_COLA, DrinkSizePrice.LARGE_COLA))),
                true, "cocacolaurl"));
        drinkRepository.save(new Drink("Pepsi",
                drinkTypeRepository.findDrinkTypesBySizePriceIn(new ArrayList<>(Arrays.asList(DrinkSizePrice.SMALL_PEPSI, DrinkSizePrice.MEDIUM_PEPSI, DrinkSizePrice.LARGE_PEPSI))),
                true, "pepsiurl"));
        drinkRepository.save(new Drink("Fanta",
                drinkTypeRepository.findDrinkTypesBySizePriceIn(new ArrayList<>(Arrays.asList(DrinkSizePrice.SMALL_FANTA, DrinkSizePrice.MEDIUM_FANTA, DrinkSizePrice.LARGE_FANTA))),
                true, "fantaurl"));
        drinkRepository.save(new Drink("Sprite",
                drinkTypeRepository.findDrinkTypesBySizePriceIn(new ArrayList<>(Arrays.asList(DrinkSizePrice.SMALL_SPRITE, DrinkSizePrice.MEDIUM_SPRITE ,DrinkSizePrice.LARGE_SPRITE))),
                true, "spriteurl"));
        drinkRepository.save(new Drink("Orange juice",
               drinkTypeRepository.findDrinkTypesBySizePriceIn(new ArrayList<>(Arrays.asList(DrinkSizePrice.SMALL_ORANGE_JUICE, DrinkSizePrice.MEDIUM_ORANGE_JUICE ,DrinkSizePrice.LARGE_ORANGE_JUICE))),
               true, "orangejuiceurl"));
        drinkRepository.save(new Drink("Apple juice",
                    drinkTypeRepository.findDrinkTypesBySizePriceIn(new ArrayList<>(Arrays.asList(DrinkSizePrice.SMALL_APPLE_JUICE, DrinkSizePrice.MEDIUM_APPLE_JUICE ,DrinkSizePrice.LARGE_APPLE_JUICE))),
                true, "applejuiceurl"));

        friesRepository.save(new Fries("Small fries", 2,true, "smallfriesurl"));
        friesRepository.save(new Fries("Medium fries", 3,true, "mediumfriesurl"));
        friesRepository.save(new Fries("Large fries", 5,true, "largefriesurl"));

        ingredientRepository.save(new Ingredient("Mozzarella", true));
    }
}
