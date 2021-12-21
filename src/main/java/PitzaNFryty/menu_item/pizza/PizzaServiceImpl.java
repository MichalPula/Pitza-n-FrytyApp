package PitzaNFryty.menu_item.pizza;

import PitzaNFryty.menu_item.MenuItem;
import PitzaNFryty.menu_item.MenuItemService;
import PitzaNFryty.menu_item.ingredient.Ingredient;
import PitzaNFryty.menu_item.ingredient.IngredientRepository;
import PitzaNFryty.menu_item.sauce.Sauce;
import PitzaNFryty.menu_item.sauce.SauceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository pizzaRepository;
    private final IngredientRepository ingredientRepository;
    private final SauceRepository sauceRepository;
    private final MenuItemService menuItemService;

    @Autowired
    public PizzaServiceImpl(PizzaRepository pizzaRepository, IngredientRepository ingredientRepository, SauceRepository sauceRepository,
                            MenuItemService menuItemService) {
        this.pizzaRepository = pizzaRepository;
        this.ingredientRepository = ingredientRepository;
        this.sauceRepository = sauceRepository;
        this.menuItemService = menuItemService;
    }

    @Override
    public List<PizzaReadDTO> getAll() {
        List<Pizza> pizzas = pizzaRepository.findAll();
        List<MenuItem> pizzasMappedToMenuItems = pizzas.stream().map(pizza -> (MenuItem) pizza).collect(Collectors.toList());
        Map<String, List<MenuItem>> menuItemNameToAllItsSizes = menuItemService.mapToMenuItemNameToAllItsSizes(pizzasMappedToMenuItems);


        List<PizzaReadDTO> pizzaReadDTOList = new ArrayList<>();
        menuItemNameToAllItsSizes.forEach((menuItemName, menuItemInAllSizes) -> {
            List<Pizza> pizzasInAllSizes = menuItemInAllSizes.stream().map(menuItem -> (Pizza) menuItem).collect(Collectors.toList());

            PizzaReadDTO pizzaReadDTO = new PizzaReadDTO();
            pizzaReadDTO.setName(menuItemName);

            Map<Long, List<String>> pizzaIdToSizeDiameterPriceList = new LinkedHashMap<>();
            pizzasInAllSizes.forEach(pizza -> {
                String pizzaSize = pizza.getPizzaSize().toString();
                String pizzaDiameter = pizza.getPizzaSize().getDiameter().toString() + "cm";
                String pizzaPrice = pizza.getPrice().toString();
                pizzaIdToSizeDiameterPriceList.put(pizza.getId(), new ArrayList<>(Arrays.asList(pizzaSize, pizzaDiameter, pizzaPrice)));
            });
            pizzaReadDTO.setPizzaIdToSizeDiameterPriceList(pizzaIdToSizeDiameterPriceList);

            Map<Long, String> ingredientIdToName= new LinkedHashMap<>();
            pizzasInAllSizes.get(0).getIngredients().forEach(ingredient -> ingredientIdToName.put(ingredient.getId(), ingredient.getName()));
            pizzaReadDTO.setIngredients(ingredientIdToName);

            Map<Long, String> sauceIdToName = new LinkedHashMap<>();
            pizzasInAllSizes.get(0).getSauces().forEach(sauce -> sauceIdToName.put(sauce.getId(), sauce.getName()));
            pizzaReadDTO.setSauces(sauceIdToName);

            pizzaReadDTO.setImageURL(pizzasInAllSizes.get(0).getImageURL());

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
