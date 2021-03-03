package PitzaNFryty.menu_item.drink;

public enum DrinkSizePrice {
    SMALL_COLA(3),MEDIUM_COLA(4),LARGE_COLA(7),
    SMALL_PEPSI(2),MEDIUM_PEPSI(3),LARGE_PEPSI(6),
    SMALL_FANTA(3),MEDIUM_FANTA(4),LARGE_FANTA(7),
    SMALL_SPRITE(3),MEDIUM_SPRITE(4),LARGE_SPRITE(7),
    SMALL_MIRINDA(3),MEDIUM_MIRINDA(4),LARGE_MIRINDA(7),
    SMALL_ORANGE_JUICE(3),MEDIUM_ORANGE_JUICE(4),LARGE_ORANGE_JUICE(7),
    SMALL_APPLE_JUICE(3),MEDIUM_APPLE_JUICE(4),LARGE_APPLE_JUICE(7);

    private final int price;

    DrinkSizePrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
