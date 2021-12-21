package PitzaNFryty.menu_item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu-items")
public class MenuItemController {

    private final MenuItemService menuItemService;

    @Autowired
    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @PostMapping(value = "/deactivate/{menuItemName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deactivateByName(@PathVariable String menuItemName) {
        return ResponseEntity.ok().body(menuItemService.deactivateByName(menuItemName));
    }
}
