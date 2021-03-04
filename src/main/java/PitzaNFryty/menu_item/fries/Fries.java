package PitzaNFryty.menu_item.fries;

import PitzaNFryty.menu_item.MenuItem;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "fries")
public class Fries extends MenuItem {

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity = FriesSize.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "fries_sizes",
            joinColumns = {@JoinColumn(name = "fries_id")},
            inverseJoinColumns = {@JoinColumn(name = "fries_size_id")})
    private Set<FriesSize> friesSizes;

    public Fries() {
    }

    public Fries(String name, Set<FriesSize> friesSizes, boolean isAvailable, String imageURL) {
        super(name, isAvailable, imageURL);
        this.friesSizes = friesSizes;
    }

    public Fries(String name, Set<FriesSize> friesSizes, String imageURL) {
        super(name, imageURL);
        this.friesSizes = friesSizes;
    }

    public Set<FriesSize> getFriesSizes() {
        return friesSizes;
    }

    public void setFriesSizes(Set<FriesSize> friesSizes) {
        this.friesSizes = friesSizes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName())
                .append("[");
        this.friesSizes.forEach(friesSize -> sb.append(friesSize.toString()).append(", "));
        sb.append("]");
        return sb.toString();
    }
}
