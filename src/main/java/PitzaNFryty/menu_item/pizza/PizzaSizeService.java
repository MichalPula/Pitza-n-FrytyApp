package PitzaNFryty.menu_item.pizza;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PizzaSizeService {
    List<PizzaSize> getAll();
}