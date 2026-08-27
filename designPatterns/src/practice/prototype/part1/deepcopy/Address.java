package practice.prototype.part1.deepcopy;

public class Address {
    String city;

    public Address(String city) {
        this.city = city;
    }

    public Address copy() {
        return new Address(this.city);
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                '}';
    }
}