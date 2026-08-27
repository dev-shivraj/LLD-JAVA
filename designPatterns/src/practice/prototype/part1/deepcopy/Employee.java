package practice.prototype.part1.deepcopy;

public class Employee {
    String name;
    Address address;

    public Employee(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Employee deepCopy() {
        return new Employee(
                this.name,
                this.address.copy()
        );
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}