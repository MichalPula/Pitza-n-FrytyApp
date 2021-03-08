package PitzaNFryty.menu_item.fries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class FriesServiceImpl implements FriesService{

    private final FriesRepository friesRepository;
    private final FriesSizeRepository friesSizeRepository;

    @Autowired
    public FriesServiceImpl(FriesRepository friesRepository, FriesSizeRepository friesSizeRepository) {
        this.friesRepository = friesRepository;
        this.friesSizeRepository = friesSizeRepository;
    }

    @Override
    public List<FriesReadDTO> getAll() {
        List<Fries> allFries = friesRepository.findAll();
        List<FriesSize> friesSizes = friesSizeRepository.findAll();
        int amountOfFries = allFries.size();
        int amountOfSameFries = friesSizes.size();

        List<FriesReadDTO> friesReadDTOList = new ArrayList<>();

        for(int i = 0; i <= amountOfFries; i += amountOfSameFries) {
            if(i > amountOfFries - amountOfSameFries) {
                break;
            }
            List<Fries> sameFries = allFries.subList(i, i + amountOfSameFries);
            FriesReadDTO friesReadDTO = new FriesReadDTO();
            Map<Long, FriesSize> friesIdToSize = new LinkedHashMap<>();
            Map<Long, BigDecimal> friesIdToPrice = new LinkedHashMap<>();

            sameFries.forEach(fries -> {
                friesIdToSize.put(fries.getId(), fries.getFriesSize());
                friesIdToPrice.put(fries.getId(), fries.getPrice());
            });
            friesReadDTO.setName(sameFries.get(0).getName());
            friesReadDTO.setFriesIdToSize(friesIdToSize);
            friesReadDTO.setDrinkIdToPrice(friesIdToPrice);
            friesReadDTO.setImageURL(sameFries.get(0).getImageURL());

            friesReadDTOList.add(friesReadDTO);
        }
        return friesReadDTOList;
    }
}
