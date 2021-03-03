package PitzaNFryty.menu_item.pizza;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaTypeRepository extends JpaRepository<PizzaSize, Long> {
    List<PizzaSize> findPizzaTypesBySizePriceIn(List<PizzaSizePrice> sizePrices);

}
