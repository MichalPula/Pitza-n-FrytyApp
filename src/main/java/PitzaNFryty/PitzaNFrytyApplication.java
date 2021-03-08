package PitzaNFryty;

import PitzaNFryty.customer.CustomerRepository;
import PitzaNFryty.menu_item.drink.DrinkRepository;

import PitzaNFryty.menu_item.fries.FriesRepository;
import PitzaNFryty.menu_item.ingredient.IngredientRepository;
import PitzaNFryty.menu_item.pizza.PizzaRepository;
import PitzaNFryty.menu_item.sauce.SauceRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PitzaNFrytyApplication {

    private static final Logger log = LoggerFactory.getLogger(PitzaNFrytyApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PitzaNFrytyApplication.class, args);
    }

    @Bean
    public CommandLineRunner clr(DrinkRepository drinkRepository, FriesRepository friesRepository,
                                 PizzaRepository pizzaRepository, CustomerRepository customerRepository,
                                 IngredientRepository ingredientRepository, SauceRepository sauceRepository){
        return args -> {
            log.info("----------------------------");
            log.info("Drinks found with findAll():");
            drinkRepository.findAll().forEach(drink -> {
                log.info(drink.toString());
            });

            log.info("----------------------------");
            log.info("Fries found with findAll():");
            friesRepository.findAll().forEach(fries -> {
                log.info(fries.toString());
            });

            log.info("----------------------------");
            log.info("Ingredients found with findAll():");
            ingredientRepository.findAll().forEach(ingredient -> {
                log.info(ingredient.toString());
            });

            log.info("----------------------------");
            log.info("Sauces found with findAll():");
            sauceRepository.findAll().forEach(sauce -> {
                log.info(sauce.toString());
            });

            log.info("----------------------------");
            log.info("Pizzas found with findAll():");
            pizzaRepository.findAll().forEach(
                    pizza -> log.info(pizza.toString())
            );

            log.info("----------------------------");
            log.info("Customers found with findAll():");
            customerRepository.findAll().forEach(
                    customer -> log.info(customer.toString())
            );
        };
    }
}
