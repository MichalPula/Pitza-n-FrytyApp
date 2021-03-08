package PitzaNFryty.menu_item.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository pizzaRepository;
    private final PizzaSizeRepository pizzaSizeRepository;

    @Autowired
    public PizzaServiceImpl(PizzaRepository pizzaRepository, PizzaSizeRepository pizzaSizeRepository) {
        this.pizzaRepository = pizzaRepository;
        this.pizzaSizeRepository = pizzaSizeRepository;
    }

    @Override
    public List<PizzaReadDTO> getAll() {
        List<Pizza> pizzas = pizzaRepository.findAll();
        List<PizzaSize> pizzaSizes = pizzaSizeRepository.findAll();
        int amountOfPizzas = pizzas.size();
        int amountOfSamePizzas = pizzaSizes.size();

        List<PizzaReadDTO> pizzaReadDTOList = new ArrayList<>();

        for(int i = 0; i <= amountOfPizzas; i += amountOfSamePizzas) {
            if(i > amountOfPizzas - amountOfSamePizzas) {
                break;
            }
            List<Pizza> samePizzas = pizzas.subList(i, i + amountOfSamePizzas);
            PizzaReadDTO pizzaReadDTO = new PizzaReadDTO();
            Map<Long, PizzaSize> pizzaIdToSize = new LinkedHashMap<>();
            Map<Long, BigDecimal> pizzaIdToPrice = new LinkedHashMap<>();
            Map<Long, String> ingredients = new LinkedHashMap<>();
            Map<Long, String> sauces = new LinkedHashMap<>();

            samePizzas.forEach(pizza -> {
                pizzaIdToSize.put(pizza.getId(), pizza.getPizzaSize());
                pizzaIdToPrice.put(pizza.getId(), pizza.getPrice());
            });
            pizzaReadDTO.setName(samePizzas.get(0).getName());
            pizzaReadDTO.setPizzaIdToSize(pizzaIdToSize);
            pizzaReadDTO.setPizzaIdToPrice(pizzaIdToPrice);
            samePizzas.get(0).getIngredients().forEach(ingredient -> ingredients.put(ingredient.getId(), ingredient.getName()));
            pizzaReadDTO.setIngredients(ingredients);
            samePizzas.get(0).getSauces().forEach(sauce -> sauces.put(sauce.getId(), sauce.getName()));
            pizzaReadDTO.setSauces(sauces);
            pizzaReadDTO.setImageURL(samePizzas.get(0).getImageURL());

            pizzaReadDTOList.add(pizzaReadDTO);
        }
        return pizzaReadDTOList;
    }
}
