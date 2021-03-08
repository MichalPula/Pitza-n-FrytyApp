package PitzaNFryty.menu_item.ingredient;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IngredientService {
    List<Ingredient> getAll();
}
