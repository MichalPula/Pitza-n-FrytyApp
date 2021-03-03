package PitzaNFryty.menu_item.fries;

public enum FriesSizePrice {
    SMALL_FRIES(2),MEDIUM_FRIES(3),LARGE_FRIES(5);

    private final int price;

    FriesSizePrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
