package PitzaNFryty.menu_item;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    MenuItem findByNameContainingIgnoreCase(String name);
    List<MenuItem> findAllByNameInIgnoreCase(List<String> menuItems);
}
