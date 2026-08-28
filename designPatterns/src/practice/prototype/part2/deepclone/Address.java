package practice.prototype.part2.deepclone;

public class Address implements Cloneable{
    private String city;

    public Address(String city) {
        this.city = city;
    }

    public Address clone() {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
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
