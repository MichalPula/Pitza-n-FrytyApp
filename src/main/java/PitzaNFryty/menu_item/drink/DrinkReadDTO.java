package PitzaNFryty.menu_item.drink;

import java.math.BigDecimal;
import java.util.Map;

public class DrinkReadDTO {

    private String name;
    private Map<Long, DrinkSize> drinkIdToSize;
    private Map<Long, BigDecimal> drinkIdToPrice;
    private String imageURL;

    public DrinkReadDTO(String name, Map<Long, DrinkSize> drinkIdToSize, Map<Long, BigDecimal> drinkIdToPrice, String imageURL) {
        this.name = name;
        this.drinkIdToSize = drinkIdToSize;
        this.drinkIdToPrice = drinkIdToPrice;
        this.imageURL = imageURL;
    }

    public DrinkReadDTO() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Long, DrinkSize> getDrinkIdToSize() {
        return drinkIdToSize;
    }

    public void setDrinkIdToSize(Map<Long, DrinkSize> drinkIdToSize) {
        this.drinkIdToSize = drinkIdToSize;
    }

    public Map<Long, BigDecimal> getDrinkIdToPrice() {
        return drinkIdToPrice;
    }

    public void setDrinkIdToPrice(Map<Long, BigDecimal> drinkIdToPrice) {
        this.drinkIdToPrice = drinkIdToPrice;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DrinkReadDTO{");
        sb.append("name='").append(name).append('\'');
        sb.append(", drinkIdToSize=").append(drinkIdToSize);
        sb.append(", drinkIdToPrice=").append(drinkIdToPrice);
        sb.append(", imageURL='").append(imageURL).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
