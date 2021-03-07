package PitzaNFryty.menu_item.fries;

import javax.persistence.*;

@Entity
@Table(name = "fries_sizes")
public class FriesSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "size")
    private String size;

    public FriesSize(String size) {
        this.size = size;
    }

    public FriesSize(){

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

    @Override
    public String toString() {
        return this.size;
    }
}
