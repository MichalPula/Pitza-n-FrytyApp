package PitzaNFryty.menu_item.drink;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkTypeRepository extends JpaRepository<DrinkType, Long> {
    List<DrinkType> findDrinkTypesBySizePriceIn(List<DrinkSizePrice> sizePrices);
}
