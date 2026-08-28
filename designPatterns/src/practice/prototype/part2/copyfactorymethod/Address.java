package practice.prototype.part2.copyfactorymethod;

public class Address{
    private String city;

    public Address(String city) {
        this.city = city;
    }

    // factory method
    public static Address from(Address other) {
        return new Address(other.city);
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                '}';
    }
}
