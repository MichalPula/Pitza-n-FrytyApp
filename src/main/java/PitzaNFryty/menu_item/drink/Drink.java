package PitzaNFryty.menu_item.drink;

import PitzaNFryty.menu_item.MenuItem;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "drinks")
public class Drink extends MenuItem {

    public Drink() {
        super();
    }
}
