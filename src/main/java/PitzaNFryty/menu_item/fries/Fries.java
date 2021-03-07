package PitzaNFryty.menu_item.fries;

import PitzaNFryty.menu_item.MenuItem;
import com.sun.istack.NotNull;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "fries")
public class Fries extends MenuItem {

    @NotNull
    @ManyToOne(targetEntity = FriesSize.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "fries_size_id")
    private FriesSize friesSize;

    @NotNull
    @Column(name = "price")
    private BigDecimal price;

    public Fries(String name, FriesSize friesSize, BigDecimal price, String imageURL) {
        super(name, imageURL);
        this.friesSize = friesSize;
        this.price = price;
    }

    public Fries() {
    }

    public FriesSize getFriesSize() {
        return friesSize;
    }

    public void setFriesSize(FriesSize friesSize) {
        this.friesSize = friesSize;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.getName() + ", " + this.friesSize.toString() +", " + this.price + ", " + this.getImageURL();
    }
}
