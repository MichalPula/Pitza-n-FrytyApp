package PitzaNFryty.menu_item.fries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriesRepository extends JpaRepository<Fries, Long> {
}
