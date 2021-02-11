package PitzaNFryty.menu_item.sauce;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SauceRepository extends JpaRepository<Sauce, Long> {
    List<Sauce> findSaucesByNameIn(List<String> saucesNames);
}
