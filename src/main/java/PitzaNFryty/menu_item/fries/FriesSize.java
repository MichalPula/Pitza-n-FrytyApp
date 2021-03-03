package PitzaNFryty.menu_item.fries;

import javax.persistence.*;

@Entity
@Table(name = "fries_sizes_prices")
public class FriesSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "fries_size_price", unique = true)
    private FriesSizePrice sizePrice;

    public FriesSize(FriesSizePrice sizePrice) {
        this.sizePrice = sizePrice;
    }

    public FriesSize(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public FriesSizePrice getSizePrice() {
        return sizePrice;
    }

    public void setSizePrice(FriesSizePrice sizePrice) {
        this.sizePrice = sizePrice;
    }

    @Override
    public String toString() {
        return this.getSizePrice().name() + "-" +
                this.getSizePrice().getPrice();
    }
}
