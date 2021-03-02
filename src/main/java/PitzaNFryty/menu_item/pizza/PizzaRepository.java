package PitzaNFryty.menu_item.pizza;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    Pizza findByName(String name);
}
