package PitzaNFryty.menu_item.drink;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "drinks_sizes")
public class DrinkSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    private long id;

    @Column(name = "size")
    private String size;

    @Column(name = "volume_in_liters")
    private BigDecimal volume;

    public DrinkSize(String size, BigDecimal volume) {
        this.size = size;
        this.volume = volume;
    }

    public DrinkSize() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return this.size + " - " + this.volume + "l";
    }
}
