package PitzaNFryty.menu_item;

import org.springframework.stereotype.Service;

@Service
public interface MenuItemService {

    String deactivateByName(String name);
}
