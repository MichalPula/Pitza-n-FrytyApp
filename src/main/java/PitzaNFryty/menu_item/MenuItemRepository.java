package PitzaNFryty.menu_item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    MenuItem findByNameContainingIgnoreCase(String name);
    List<MenuItem> findAllByNameInIgnoreCase(List<String> menuItems);
}
