package PitzaNFryty.menu_item.drink;

public enum DrinkSizePrice {
    SMALL(2),
    MEDIUM(3),
    LARGE(5);

    private final int price;

    DrinkSizePrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
