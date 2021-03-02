package PitzaNFryty.menu_item;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    MenuItem findByName(String name);
}
