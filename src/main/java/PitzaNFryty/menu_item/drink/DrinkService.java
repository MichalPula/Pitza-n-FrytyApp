package PitzaNFryty.menu_item.drink;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DrinkService {

    List<DrinkReadDTO> getAll();
}
