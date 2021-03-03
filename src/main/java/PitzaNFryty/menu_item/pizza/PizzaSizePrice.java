package PitzaNFryty.menu_item.pizza;

public enum PizzaSizePrice {
    SMALL_MARGHERITA(30,21), MEDIUM_MARGHERITA(40,28), LARGE_MARGHERITA(50,32),
    SMALL_CAPRICCIOSA(30,25), MEDIUM_CAPRICCIOSA(40,31), LARGE_CAPRICCIOSA(50,39),
    SMALL_PEPPERONI(30,23), MEDIUM_PEPPERONI(40,30), LARGE_PEPPERONI(50,37),
    SMALL_HAWAIIAN(30,24), MEDIUM_HAWAIIAN(40,32), LARGE_HAWAIIAN(50,40),
    SMALL_FARMER(30,27), MEDIUM_FARMER(40,34), LARGE_FARMER(50,42),
    SMALL_MEAT(30,28), MEDIUM_MEAT(40,37), LARGE_MEAT(50,45),
    SMALL_PARMA(30,32), MEDIUM_PARMA(40,39), LARGE_PARMA(50,49);

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
