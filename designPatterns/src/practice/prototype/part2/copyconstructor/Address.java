package practice.prototype.part2.copyconstructor;

public class Address{
    private String city;

    public Address(String city) {
        this.city = city;
    }

    public Address(Address other) {
        this.city = other.city;
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
