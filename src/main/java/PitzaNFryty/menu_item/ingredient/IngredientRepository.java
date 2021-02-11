package PitzaNFryty.menu_item.ingredient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findIngredientsByNameIn(List<String> ingredientsNames);
    Ingredient findIngredientByName(String ingredientName);
}
