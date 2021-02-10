package PitzaNFryty.menu_item.fries;

import PitzaNFryty.menu_item.MenuItem;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "fries")
public class Fries extends MenuItem {

    public Fries() {
    }

    public Fries(String name, boolean available, String imageURL) {
        super(name, available, imageURL);
    }


}
