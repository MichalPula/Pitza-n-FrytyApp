package PitzaNFryty.menu_item.sauce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SauceServiceImpl implements SauceService {

    private final SauceRepository sauceRepository;

    @Autowired
    public SauceServiceImpl(SauceRepository sauceRepository) {
        this.sauceRepository = sauceRepository;
    }

    @Override
    public List<Sauce> getAll() {
        return sauceRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
}
