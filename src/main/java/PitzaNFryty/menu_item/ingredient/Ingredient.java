package PitzaNFryty.menu_item.ingredient;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    private long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "is_available")
    private boolean isAvailable = true;

    public Ingredient(String name, boolean isAvailable) {
        this.name = name;
        this.isAvailable = isAvailable;
    }

    public Ingredient(String name) {
        this.name = name;
    }

    public Ingredient() {

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
