package PitzaNFryty.menu_item.fries;

import java.math.BigDecimal;
import java.util.Map;

public class FriesReadDTO {

    private String name;
    private Map<Long, FriesSize> friesIdToSize;
    private Map<Long, BigDecimal> friesIdToPrice;
    private String imageURL;

    public FriesReadDTO(String name, Map<Long, FriesSize> friesIdToSize, Map<Long, BigDecimal> friesIdToPrice, String imageURL) {
        this.name = name;
        this.friesIdToSize = friesIdToSize;
        this.friesIdToPrice = friesIdToPrice;
        this.imageURL = imageURL;
    }

    public FriesReadDTO() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Long, FriesSize> getFriesIdToSize() {
        return friesIdToSize;
    }

    public void setFriesIdToSize(Map<Long, FriesSize> friesIdToSize) {
        this.friesIdToSize = friesIdToSize;
    }

    public Map<Long, BigDecimal> getDrinkIdToPrice() {
        return friesIdToPrice;
    }

    public void setDrinkIdToPrice(Map<Long, BigDecimal> friesIdToPrice) {
        this.friesIdToPrice = friesIdToPrice;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FriesReadDTO{");
        sb.append("name='").append(name).append('\'');
        sb.append(", friesIdToSize=").append(friesIdToSize);
        sb.append(", friesIdToPrice=").append(friesIdToPrice);
        sb.append(", imageURL='").append(imageURL).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
