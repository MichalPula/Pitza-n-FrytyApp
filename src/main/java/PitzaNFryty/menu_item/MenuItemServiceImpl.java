package PitzaNFryty.menu_item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemServiceImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public String deactivateByName(String name) {
        List<MenuItem> menuItems = menuItemRepository.findAllByNameLikeIgnoreCase(name);
        menuItems.forEach(menuItem -> menuItem.setAvailable(false));
        menuItemRepository.saveAll(menuItems);
        return "All sizes of " + name + " have been deactivated.";
    }
}
