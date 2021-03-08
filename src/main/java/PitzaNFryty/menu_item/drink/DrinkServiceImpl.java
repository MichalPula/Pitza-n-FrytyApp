package PitzaNFryty.menu_item.drink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class DrinkServiceImpl implements DrinkService{

    private final DrinkRepository drinkRepository;
    private final DrinkSizeRepository drinkSizeRepository;

    @Autowired
    public DrinkServiceImpl(DrinkRepository drinkRepository, DrinkSizeRepository drinkSizeRepository) {
        this.drinkRepository = drinkRepository;
        this.drinkSizeRepository = drinkSizeRepository;
    }

    @Override
    public List<DrinkReadDTO> getAll() {
        List<Drink> drinks = drinkRepository.findAll();
        List<DrinkSize> drinkSizes = drinkSizeRepository.findAll();
        int amountOfDrinks = drinks.size();
        int amountOfSameDrinks = drinkSizes.size();

        List<DrinkReadDTO> drinkReadDTOList = new ArrayList<>();

        for(int i = 0; i <= amountOfDrinks; i += amountOfSameDrinks) {
            if(i > amountOfDrinks - amountOfSameDrinks) {
                break;
            }
            List<Drink> sameDrinks = drinks.subList(i, i + amountOfSameDrinks);
            DrinkReadDTO drinkReadDTO = new DrinkReadDTO();
            Map<Long, DrinkSize> drinkIdToSize = new LinkedHashMap<>();
            Map<Long, BigDecimal> drinkIdToPrice = new LinkedHashMap<>();

            sameDrinks.forEach(drink -> {
                drinkIdToSize.put(drink.getId(), drink.getDrinkSize());
                drinkIdToPrice.put(drink.getId(), drink.getPrice());
            });
            drinkReadDTO.setName(sameDrinks.get(0).getName());
            drinkReadDTO.setDrinkIdToSize(drinkIdToSize);
            drinkReadDTO.setDrinkIdToPrice(drinkIdToPrice);
            drinkReadDTO.setImageURL(sameDrinks.get(0).getImageURL());

            drinkReadDTOList.add(drinkReadDTO);
        }
        return drinkReadDTOList;
    }
}
