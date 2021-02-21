package PitzaNFryty.menu_item.pizza;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaTypeRepository extends JpaRepository<PizzaType, Long> {
}
