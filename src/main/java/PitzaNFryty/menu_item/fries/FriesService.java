package PitzaNFryty.menu_item.fries;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FriesService {
    List<FriesReadDTO> getAll();
}
