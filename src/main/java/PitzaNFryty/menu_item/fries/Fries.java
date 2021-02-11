package PitzaNFryty.menu_item.fries;

import PitzaNFryty.menu_item.MenuItem;
import javax.persistence.*;

@Entity
@Table(name = "fries")
public class Fries extends MenuItem {

    private int price;

    public Fries() {
    }

    public Fries(String name, int price, boolean available, String imageURL) {
        super(name, available, imageURL);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
