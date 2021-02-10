package PitzaNFryty;

import PitzaNFryty.menu_item.drink.Drink;
import PitzaNFryty.menu_item.drink.DrinkRepository;
import org.springframework.stereotype.Service;

@Service
public class Initializer {
    public Initializer(DrinkRepository drinkRepository){

        drinkRepository.save(new Drink("Coca-Cola", true, "cocacolaurl"));
        drinkRepository.save(new Drink("Pepsi", true, "pepsiurl"));
        drinkRepository.save(new Drink("Fanta", true, "fantaurl"));
        drinkRepository.save(new Drink("Sprite", true, "spriteurl"));
        drinkRepository.save(new Drink("Orange juice", true, "orangejuiceurl"));
        drinkRepository.save(new Drink("Apple juice", true, "applejuiceurl"));
    }
}
