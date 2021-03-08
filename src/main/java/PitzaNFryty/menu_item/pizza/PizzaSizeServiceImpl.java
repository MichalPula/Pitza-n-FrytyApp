package PitzaNFryty.menu_item.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaSizeServiceImpl implements PizzaSizeService {

    private final PizzaSizeRepository pizzaSizeRepository;

    @Autowired
    public PizzaSizeServiceImpl(PizzaSizeRepository pizzaSizeRepository) {
        this.pizzaSizeRepository = pizzaSizeRepository;
    }

    @Override
    public List<PizzaSize> getAll() {
        return pizzaSizeRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
}
