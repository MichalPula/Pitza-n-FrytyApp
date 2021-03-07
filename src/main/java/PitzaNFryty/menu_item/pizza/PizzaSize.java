package PitzaNFryty.menu_item.pizza;

import javax.persistence.*;

@Entity
@Table(name = "pizzas_sizes")
public class PizzaSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    private long id;

    @Column(name = "size")
    private String size;

    @Column(name = "diameter_in_cm")
    private Integer diameter;

    public PizzaSize(String size, Integer diameter) {
        this.size = size;
        this.diameter = diameter;
    }

    public PizzaSize() {

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

    public Integer getDiameter() {
        return diameter;
    }

    public void setDiameter(Integer diameter) {
        this.diameter = diameter;
    }

    @Override
    public String toString() {

        return this.size + " - " + this.diameter + "cm";

    }
}
