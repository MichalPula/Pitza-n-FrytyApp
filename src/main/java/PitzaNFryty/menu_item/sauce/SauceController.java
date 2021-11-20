package PitzaNFryty.menu_item.sauce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sauces")
public class SauceController {

    private final SauceService sauceService;

    @Autowired
    public SauceController(SauceService sauceService) {
        this.sauceService = sauceService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Sauce>> getAll(){
        return ResponseEntity.ok().body(this.sauceService.getAll());
    }
}
