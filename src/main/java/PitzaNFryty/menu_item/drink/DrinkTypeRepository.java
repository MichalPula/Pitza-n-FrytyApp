package PitzaNFryty.menu_item.drink;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface DrinkTypeRepository extends JpaRepository<DrinkSize, Long> {
    Set<DrinkSize> findDrinkTypesBySizePriceIn(List<DrinkSizePrice> sizePrices);
}
