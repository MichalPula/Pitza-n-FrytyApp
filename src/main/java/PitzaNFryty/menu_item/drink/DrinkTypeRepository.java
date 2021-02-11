package PitzaNFryty.menu_item.drink;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkTypeRepository extends JpaRepository<DrinkSize, Long> {
    List<DrinkSize> findDrinkTypesBySizePriceIn(List<DrinkSizePrice> sizePrices);
}
