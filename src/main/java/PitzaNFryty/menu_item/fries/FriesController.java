package PitzaNFryty.menu_item.fries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
