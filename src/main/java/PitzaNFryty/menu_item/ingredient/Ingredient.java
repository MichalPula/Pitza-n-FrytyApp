//package PitzaNFryty.menu_item.ingredient;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "ingredients")
//public class Ingredient {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", unique = true, updatable = false)
//    private long id;
//
//    @Column(name = "name", unique = true)
//    private String name;
//
//    @Column(name = "available")
//    private boolean available;
//
//    public Ingredient(String name, boolean available) {
//        this.name = name;
//        this.available = available;
//    }
//
//    public Ingredient() {
//
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public boolean isAvailable() {
//        return available;
//    }
//
//    public void setAvailable(boolean available) {
//        this.available = available;
//    }
//}
