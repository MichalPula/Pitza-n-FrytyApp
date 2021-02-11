//package PitzaNFryty.menu_item.sauce;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "sauces")
//public class Sauce {
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
//    public Sauce(String name, boolean available) {
//        this.name = name;
//        this.available = available;
//    }
//
//    public Sauce() {
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
