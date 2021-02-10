package PitzaNFryty;

import PitzaNFryty.menu_item.drink.DrinkRepository;

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
    public CommandLineRunner clr(DrinkRepository drinkRepository){
        return args -> {
            log.info("Drinks found with findAll():");
            log.info("----------------------------");
            drinkRepository.findAll().forEach(drink -> log.info(drink.getId() + ", " + drink.getName() + ", " + drink.getImageURL()));
        };
    }

}
