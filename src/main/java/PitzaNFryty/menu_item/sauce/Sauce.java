package PitzaNFryty.menu_item.sauce;

import javax.persistence.*;

@Entity
@Table(name = "sauces")
public class Sauce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    private long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "is_available")
    private boolean isAvailable;

    public Sauce(String name, boolean isAvailable) {
        this.name = name;
        this.isAvailable = isAvailable;
    }

    public Sauce(String name) {
        this.name = name;
    }

    public Sauce() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
