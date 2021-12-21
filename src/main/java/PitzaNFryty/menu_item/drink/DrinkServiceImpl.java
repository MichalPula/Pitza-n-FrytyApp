package PitzaNFryty.menu_item.drink;

import PitzaNFryty.menu_item.MenuItem;
import PitzaNFryty.menu_item.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DrinkServiceImpl implements DrinkService{

    private final DrinkRepository drinkRepository;
    private final MenuItemService menuItemService;

    @Autowired
    public DrinkServiceImpl(DrinkRepository drinkRepository, MenuItemService menuItemService) {
        this.drinkRepository = drinkRepository;
        this.menuItemService = menuItemService;
    }

    @Override
    public List<DrinkReadDTO> getAll() {
        List<Drink> drinks = drinkRepository.findAll();
        List<MenuItem> drinksMappedToMenuItems = drinks.stream().map(drink -> (MenuItem) drink).collect(Collectors.toList());
        Map<String, List<MenuItem>> menuItemNameToAllItsSizes = menuItemService.mapToMenuItemNameToAllItsSizes(drinksMappedToMenuItems);

        List<DrinkReadDTO> drinksReadDTOs = new ArrayList<>();
        menuItemNameToAllItsSizes.forEach((menuItemName, menuItemInAllSizes) -> {
            List<Drink> drinkInAllSizes = menuItemInAllSizes.stream().map(menuItem -> (Drink) menuItem).collect(Collectors.toList());

            DrinkReadDTO drinkReadDTO = new DrinkReadDTO();
            drinkReadDTO.setName(menuItemName);

            Map<Long, List<String>> drinkIdToSizeVolumePriceList = new LinkedHashMap<>();
            drinkInAllSizes.forEach(drink -> {
                String drinkSize = drink.getDrinkSize().toString();
                String drinkVolume = drink.getDrinkSize().getVolume().toString() + "l";
                String drinkPrice = drink.getPrice().toString();
                drinkIdToSizeVolumePriceList.put(drink.getId(), new ArrayList<>(Arrays.asList(drinkSize, drinkVolume, drinkPrice)));
            });
            drinkReadDTO.setDrinkIdToSizeVolumePriceList(drinkIdToSizeVolumePriceList);

            drinkReadDTO.setImageURL(drinkInAllSizes.get(0).getImageURL());

            drinksReadDTOs.add(drinkReadDTO);
        });

        return drinksReadDTOs;
    }

    @Override
    public String add(DrinkCreateDTO drinkCreateDTO) {
        drinkCreateDTO.getSizeToPrice().forEach((size, price) -> {
            Drink newDrink = new Drink();
            newDrink.setName(drinkCreateDTO.getName());
            newDrink.setPrice(price);
            newDrink.setDrinkSize(DrinkSize.valueOf(size.toUpperCase()));
            newDrink.setImageURL(drinkCreateDTO.getImageURL());
            drinkRepository.save(newDrink);
        });

        return "Drink " + drinkCreateDTO.getName() + " has been added!";
    }
}
