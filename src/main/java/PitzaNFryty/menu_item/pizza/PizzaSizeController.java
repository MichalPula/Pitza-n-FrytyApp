package PitzaNFryty.menu_item.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pizza/size")
public class PizzaSizeController {

    private final PizzaSizeService pizzaSizeService;

    @Autowired
    public PizzaSizeController(PizzaSizeService pizzaSizeService) {
        this.pizzaSizeService = pizzaSizeService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PizzaSize>> getAll() {
        return ResponseEntity.ok().body(pizzaSizeService.getAll());
    }
}
