package PitzaNFryty;

import PitzaNFryty.menu_item.drink.*;
import PitzaNFryty.menu_item.fries.Fries;
import PitzaNFryty.menu_item.fries.FriesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class Initializer {
    public Initializer(DrinkRepository drinkRepository, FriesRepository friesRepository,
                       DrinkTypeRepository drinkTypeRepository){

        Arrays.stream(DrinkSizePrice.values()).forEach(drinkSizePrice -> {
            DrinkType drinkType = new DrinkType(drinkSizePrice);
            drinkTypeRepository.save(drinkType);
        });

        drinkRepository.save(new Drink("Coca-Cola",
                drinkTypeRepository.findDrinkTypesBySizePriceIn(new ArrayList<>(Arrays.asList(DrinkSizePrice.SMALL_COLA, DrinkSizePrice.MEDIUM_COLA, DrinkSizePrice.LARGE_COLA))),
                true, "cocacolaurl"));
       drinkRepository.save(new Drink("Orange juice",
               drinkTypeRepository.findDrinkTypesBySizePriceIn(new ArrayList<>(Arrays.asList(DrinkSizePrice.SMALL_ORANGE_JUICE, DrinkSizePrice.MEDIUM_ORANGE_JUICE ,DrinkSizePrice.LARGE_ORANGE_JUICE))),
               true, "orangejuiceurl"));
        drinkRepository.save(new Drink("Sprite",
                drinkTypeRepository.findDrinkTypesBySizePriceIn(new ArrayList<>(Arrays.asList(DrinkSizePrice.SMALL_SPRITE, DrinkSizePrice.MEDIUM_SPRITE ,DrinkSizePrice.LARGE_SPRITE))),
                true, "spriteurl"));
//        drinkRepository.save(new Drink("Fanta", true, "fantaurl"));
//        drinkRepository.save(new Drink("Pepsi", true, "pepsiaurl"));
//        drinkRepository.save(new Drink("Sprite", true, "spriteurl"));
//        drinkRepository.save(new Drink("Orange juice", true, "orangejuiceurl"));
//        drinkRepository.save(new Drink("Apple juice", true, "applejuiceurl"));

        friesRepository.save(new Fries("Small fries", 2,true, "smallfriesurl"));
        friesRepository.save(new Fries("Medium fries", 3,true, "mediumfriesurl"));
        friesRepository.save(new Fries("Large fries", 5,true, "largefriesurl"));
    }
}
