package PitzaNFryty.menu_item;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface MenuItemService {

    String deactivateByName(String name);
    Map<String, List<MenuItem>> mapToMenuItemNameToAllItsSizes(List<MenuItem> menuItems);
}
