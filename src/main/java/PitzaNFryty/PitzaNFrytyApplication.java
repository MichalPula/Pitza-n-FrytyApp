package PitzaNFryty;

import PitzaNFryty.customer.CustomerRepository;
import PitzaNFryty.menu_item.drink.DrinkRepository;

import PitzaNFryty.menu_item.fries.FriesRepository;
import PitzaNFryty.menu_item.pizza.PizzaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class PitzaNFrytyApplication {

    private static final Logger log = LoggerFactory.getLogger(PitzaNFrytyApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PitzaNFrytyApplication.class, args);
    }

    @Bean
    public CommandLineRunner clr(DrinkRepository drinkRepository, FriesRepository friesRepository,
                                 PizzaRepository pizzaRepository, CustomerRepository customerRepository){
        return args -> {
//            log.info("----------------------------");
//            log.info("Drinks found with findAll():");
//            drinkRepository.findAll().forEach(
//                    drink -> log.info(drink.getId() + ", "
//                            + drink.getName() + ", "
//                            + Arrays.toString(drink.getDrinkSizes().toArray()) + ", "
//                            + drink.getImageURL() + ", "
//                            + drink.isIsAvailable()));

//            log.info("----------------------------");
//            log.info("Fries found with findAll():");
//            friesRepository.findAll().forEach(fries -> log.info(
//                    fries.getId() + ", "
//                    + fries.getName() + ", "
//                    + Arrays.toString(fries.getFriesSizes().toArray()) + ", "
//                    + fries.getImageURL()));

            log.info("----------------------------");
            log.info("Pizzas found with findAll():");
            pizzaRepository.findAll().forEach(
                    pizza -> log.info(pizza.toString())
            );

//            log.info("----------------------------");
//            log.info("Customers found with findAll():");
//            customerRepository.findAll().forEach(
//                    customer -> log.info(customer.toString())
//            );

        };
    }

}
