package PitzaNFryty.menu_item.fries;

import PitzaNFryty.menu_item.drink.DrinkCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fries")
public class FriesController {

    private final FriesService friesService;

    @Autowired
    public FriesController(FriesService friesService) {
        this.friesService = friesService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FriesReadDTO>> getAll(){
        return ResponseEntity.ok().body(friesService.getAll());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> add(@RequestBody FriesCreateDTO friesCreateDTO) {
        return ResponseEntity.ok().body(friesService.add(friesCreateDTO));
    }
}
