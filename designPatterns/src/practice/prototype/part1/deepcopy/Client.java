package practice.prototype.part1.deepcopy;

public class Client {

    public static void main(String[] args) {
        Address address = new Address("Bangalore");

        Employee employee1 = new Employee("Shivraj", address);
        Employee employee2 = employee1.deepCopy();

        System.out.println(employee1);
        System.out.println(employee2);

        employee2.address.city = "Mumbai";

        System.out.println();
        System.out.println("After modification:");

        System.out.println(employee1);
        System.out.println(employee2);
    }
}