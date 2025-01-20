import java.util.Objects;

public class Address {
    private String country;
    private String city;

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public Address() {

    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city);
    }

    @Override
    public boolean equals(Object obj) {
        Address address = (Address) obj;
        return country.equals(address.country) && city.equals(address.city);
    }
}
