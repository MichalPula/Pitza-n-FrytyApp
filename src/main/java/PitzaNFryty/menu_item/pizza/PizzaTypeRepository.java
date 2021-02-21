package PitzaNFryty.menu_item.pizza;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaTypeRepository extends JpaRepository<PizzaType, Long> {
    List<PizzaType> findPizzaTypesBySizePriceIn(List<PizzaSizePrice> sizePrices);

}
