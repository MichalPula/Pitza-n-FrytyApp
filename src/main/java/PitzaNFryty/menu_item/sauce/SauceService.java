package PitzaNFryty.menu_item.sauce;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SauceService {
    List<Sauce> getAll();
}
