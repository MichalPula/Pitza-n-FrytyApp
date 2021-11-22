package PitzaNFryty.menu_item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String, List<MenuItem>> mapToMenuItemNameToAllItsSizes(List<MenuItem> menuItems) {
        Map<String, List<MenuItem>> menuItemNameToAllItsSizes = new LinkedHashMap<>();

        menuItems.forEach(menuItem -> {
            String menuItemName = menuItem.getName();
            if(menuItemNameToAllItsSizes.get(menuItemName) == null){
                menuItemNameToAllItsSizes.put(menuItemName, new ArrayList<>(List.of(menuItem)));
            } else {
                menuItemNameToAllItsSizes.get(menuItemName).add(menuItem);
            }
        });

        return menuItemNameToAllItsSizes;
    }
}
