package PitzaNFryty.address;

public class AddressReadDTO {

    private Long id;
    private String city;
    private String zipCode;
    private String street;
    private String buildingNumber;
    private String flatNumber;

    public AddressReadDTO(Long id, String city, String zipCode, String street, String buildingNumber, String flatNumber) {
        this.id = id;
        this.city = city;
        this.zipCode = zipCode;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.flatNumber = flatNumber;
    }

    public AddressReadDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }
}
