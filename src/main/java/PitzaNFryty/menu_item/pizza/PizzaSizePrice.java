package PitzaNFryty.menu_item.pizza;

public enum PizzaSizePrice {
    SMALL_MARGHERITA(30,21), MEDIUM_MARGHERITA(40,28), LARGE_MARGHERITA(50,32),
    SMALL_CAPRICCIOSA(30,25), MEDIUM_CAPRICCIOSA(40,31), LARGE_CAPRICCIOSA(50,39);

    private final int diameter;
    private final int price;

    PizzaSizePrice(int diameter, int price) {
        this.diameter = diameter;
        this.price = price;
    }

    public int getDiameter() {
        return diameter;
    }

    public int getPrice() {
        return price;
    }
}
