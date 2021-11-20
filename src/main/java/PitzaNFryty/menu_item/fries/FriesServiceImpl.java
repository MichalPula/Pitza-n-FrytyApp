package PitzaNFryty.menu_item.fries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FriesServiceImpl implements FriesService{

    private final FriesRepository friesRepository;

    @Autowired
    public FriesServiceImpl(FriesRepository friesRepository) {
        this.friesRepository = friesRepository;
    }

    @Override
    public List<FriesReadDTO> getAll() {
        List<Fries> fries = friesRepository.findAll();
        Map<String, List<Fries>> friesNameToFriesSizes = new LinkedHashMap<>();

        fries.forEach(singleFries -> {
            String friesName = singleFries.getName();
            if(friesNameToFriesSizes.get(friesName) == null){
                friesNameToFriesSizes.put(friesName, new ArrayList<>(List.of(singleFries)));
            } else {
                friesNameToFriesSizes.get(friesName).add(singleFries);
            }
        });


        List<FriesReadDTO> friesReadDTOs = new ArrayList<>();
        friesNameToFriesSizes.forEach((friesName, friesInAllSizes) -> {
            FriesReadDTO friesReadDTO = new FriesReadDTO();
            friesReadDTO.setName(friesName);

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
}
