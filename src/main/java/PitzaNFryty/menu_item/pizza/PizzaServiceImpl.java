package PitzaNFryty.menu_item.pizza;

import PitzaNFryty.menu_item.ingredient.Ingredient;
import PitzaNFryty.menu_item.ingredient.IngredientRepository;
import PitzaNFryty.menu_item.sauce.Sauce;
import PitzaNFryty.menu_item.sauce.SauceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository pizzaRepository;
    private final IngredientRepository ingredientRepository;
    private final SauceRepository sauceRepository;

    @Autowired
    public PizzaServiceImpl(PizzaRepository pizzaRepository, IngredientRepository ingredientRepository, SauceRepository sauceRepository) {
        this.pizzaRepository = pizzaRepository;
        this.ingredientRepository = ingredientRepository;
        this.sauceRepository = sauceRepository;
    }

    @Override
    public List<PizzaReadDTO> getAll() {
        List<Pizza> pizzas = pizzaRepository.findAll();
        Map<String, List<Pizza>> pizzaNameToPizzasSizes = new LinkedHashMap<>();

        pizzas.forEach(pizza -> {
            String friesName = pizza.getName();
            if(pizzaNameToPizzasSizes.get(friesName) == null){
                pizzaNameToPizzasSizes.put(friesName, new ArrayList<>(List.of(pizza)));
            } else {
                pizzaNameToPizzasSizes.get(friesName).add(pizza);
            }
        });


        List<PizzaReadDTO> pizzaReadDTOList = new ArrayList<>();
        pizzaNameToPizzasSizes.forEach((pizzaName, pizzaInAllSizes) -> {
            PizzaReadDTO pizzaReadDTO = new PizzaReadDTO();
            pizzaReadDTO.setName(pizzaName);

            Map<Long, List<String>> pizzaIdToSizeDiameterPriceList = new LinkedHashMap<>();
            pizzaInAllSizes.forEach(pizza -> {
                String pizzaSize = pizza.getPizzaSize().toString();
                String pizzaDiameter = pizza.getPizzaSize().getDiameter().toString() + "cm";
                String pizzaPrice = pizza.getPrice().toString();
                pizzaIdToSizeDiameterPriceList.put(pizza.getId(), new ArrayList<>(Arrays.asList(pizzaSize, pizzaDiameter, pizzaPrice)));
            });
            pizzaReadDTO.setPizzaIdToSizeDiameterPriceList(pizzaIdToSizeDiameterPriceList);

            Map<Long, String> ingredientIdToName= new LinkedHashMap<>();
            pizzaInAllSizes.get(0).getIngredients().forEach(ingredient -> ingredientIdToName.put(ingredient.getId(), ingredient.getName()));
            pizzaReadDTO.setIngredients(ingredientIdToName);

            Map<Long, String> sauceIdToName = new LinkedHashMap<>();
            pizzaInAllSizes.get(0).getSauces().forEach(sauce -> sauceIdToName.put(sauce.getId(), sauce.getName()));
            pizzaReadDTO.setSauces(sauceIdToName);

            pizzaReadDTO.setImageURL(pizzaInAllSizes.get(0).getImageURL());

            pizzaReadDTOList.add(pizzaReadDTO);
        });

        return pizzaReadDTOList;
    }

    @Override
    public String add(PizzaCreateDTO pizzaCreateDTO) {
        List<Ingredient> ingredients = ingredientRepository.findAllByIdIn(pizzaCreateDTO.getIngredientsIds());
        List<Sauce> sauces = sauceRepository.findAllByIdIn(pizzaCreateDTO.getSaucesIds());

        pizzaCreateDTO.getSizeToPrice().forEach((size, price) -> {
            Pizza newPizza = new Pizza();
            newPizza.setName(pizzaCreateDTO.getName());
            newPizza.setPizzaSize(PizzaSize.valueOf(size.toUpperCase()));
            newPizza.setPrice(price);
            newPizza.setIngredients(ingredients);
            newPizza.setSauces(sauces);
            newPizza.setImageURL(pizzaCreateDTO.getImageURL());
            pizzaRepository.save(newPizza);
        });

        return "Pizza " + pizzaCreateDTO.getName() + " has been added!";
    }
}
