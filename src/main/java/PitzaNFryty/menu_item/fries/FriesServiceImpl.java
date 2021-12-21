package PitzaNFryty.menu_item.fries;

import PitzaNFryty.menu_item.MenuItem;
import PitzaNFryty.menu_item.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FriesServiceImpl implements FriesService{

    private final FriesRepository friesRepository;
    private final MenuItemService menuItemService;

    @Autowired
    public FriesServiceImpl(FriesRepository friesRepository, MenuItemService menuItemService) {
        this.friesRepository = friesRepository;
        this.menuItemService = menuItemService;
    }

    @Override
    public List<FriesReadDTO> getAll() {
        List<Fries> allFries = friesRepository.findAll();
        List<MenuItem> friesMappedToMenuItems = allFries.stream().map(fries -> (MenuItem) fries).collect(Collectors.toList());
        Map<String, List<MenuItem>> menuItemNameToAllItsSizes = menuItemService.mapToMenuItemNameToAllItsSizes(friesMappedToMenuItems);

        List<FriesReadDTO> friesReadDTOs = new ArrayList<>();
        menuItemNameToAllItsSizes.forEach((menuItemName, menuItemInAllSizes) -> {
            List<Fries> friesInAllSizes = menuItemInAllSizes.stream().map(menuItem -> (Fries) menuItem).collect(Collectors.toList());

            FriesReadDTO friesReadDTO = new FriesReadDTO();
            friesReadDTO.setName(menuItemName);

            Map<Long, List<String>> friesIdToSizeWeightPriceList = new LinkedHashMap<>();
            friesInAllSizes.forEach(singleFries -> {
                String friesSize = singleFries.getFriesSize().toString();
                String friesWeight = singleFries.getFriesSize().getWeight().toString() + "g";
                String friesPrice = singleFries.getPrice().toString();
                friesIdToSizeWeightPriceList.put(singleFries.getId(), new ArrayList<>(Arrays.asList(friesSize, friesWeight, friesPrice)));
            });
            friesReadDTO.setFriesIdToSizeWeightPriceList(friesIdToSizeWeightPriceList);

            friesReadDTO.setImageURL(friesInAllSizes.get(0).getImageURL());

            friesReadDTOs.add(friesReadDTO);
        });

        return friesReadDTOs;
    }

    @Override
    public String add(FriesCreateDTO friesCreateDTO) {
        friesCreateDTO.getSizeToPrice().forEach((size, price) -> {
            Fries newFries = new Fries();
            newFries.setName(friesCreateDTO.getName());
            newFries.setPrice(price);
            newFries.setFriesSize(FriesSize.valueOf(size.toUpperCase()));
            newFries.setImageURL(friesCreateDTO.getImageURL());
            friesRepository.save(newFries);
        });

        return friesCreateDTO.getName() + " have been added!";
    }
}
