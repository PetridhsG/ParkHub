
import java.util.Objects;
public class Address{

    private String street;
    private int stNumber;
    private String city;
    private String region;

    public Address(String street, int stNumber, String city, String region) {
        this.street = street;
        this.stNumber = stNumber;
        this.city = city;
        this.region = region;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStNumber() {
        return stNumber;
    }

    public void setStNumber(int stNumber) {
        this.stNumber = stNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return stNumber == address.stNumber && Objects.equals(street, address.street) && Objects.equals(city, address.city) && Objects.equals(region, address.region);

    }

}
