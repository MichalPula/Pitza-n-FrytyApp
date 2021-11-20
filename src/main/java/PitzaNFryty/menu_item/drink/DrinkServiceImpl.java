package PitzaNFryty.menu_item.drink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DrinkServiceImpl implements DrinkService{

    private final DrinkRepository drinkRepository;

    @Autowired
    public DrinkServiceImpl(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    @Override
    public List<DrinkReadDTO> getAll() {
        List<Drink> drinks = drinkRepository.findAll();
        Map<String, List<Drink>> drinkNameToDrinkSizes = new HashMap<>();

        drinks.forEach(drink -> {
            String drinkName = drink.getName();
            if(drinkNameToDrinkSizes.get(drinkName) == null){
                drinkNameToDrinkSizes.put(drinkName, new ArrayList<>(List.of(drink)));
            } else {
                drinkNameToDrinkSizes.get(drinkName).add(drink);
            }
        });


        List<DrinkReadDTO> drinksReadDTOs = new ArrayList<>();
        drinkNameToDrinkSizes.forEach((drinkName, drinkInAllSizes) -> {
            DrinkReadDTO drinkReadDTO = new DrinkReadDTO();
            drinkReadDTO.setName(drinkName);

            Map<Long, List<String>> drinkIdToSizeVolumePriceList = new HashMap<>();
            drinkInAllSizes.forEach(drink -> {
                String drinkSize = drink.getDrinkSize().toString();
                String drinkVolume = drink.getDrinkSize().getVolume().toString();
                String drinkPrice = drink.getPrice().toString();
                drinkIdToSizeVolumePriceList.put(drink.getId(), new ArrayList<>(Arrays.asList(drinkSize, drinkVolume, drinkPrice)));
            });
            drinkReadDTO.setDrinkIdToSizeVolumePriceList(drinkIdToSizeVolumePriceList);

            drinkReadDTO.setImageURL(drinkInAllSizes.get(0).getImageURL());

            drinksReadDTOs.add(drinkReadDTO);
        });

        return drinksReadDTOs;
    }
}
