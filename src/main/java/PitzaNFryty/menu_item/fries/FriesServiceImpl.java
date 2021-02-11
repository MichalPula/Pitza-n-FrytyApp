package PitzaNFryty.menu_item.fries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriesServiceImpl implements FriesService{

    private final FriesRepository friesRepository;

    @Autowired
    public FriesServiceImpl(FriesRepository friesRepository) {
        this.friesRepository = friesRepository;
    }

    @Override
    public List<Fries> getAll() {
        return friesRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
}
