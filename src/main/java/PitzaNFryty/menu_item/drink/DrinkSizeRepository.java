package PitzaNFryty.menu_item.drink;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkSizeRepository extends JpaRepository<DrinkSize, Long> {
}
