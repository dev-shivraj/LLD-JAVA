package practice.prototype.part2.copyconstructor;

public class Client {
    public static void main(String[] args) {
        Address address = new Address("Bangalore");

        Employee employee1 = new Employee("Shivraj", address);
        Employee employee2 = new Employee(employee1);

        System.out.println(employee1);
        System.out.println(employee2);

        System.out.println(employee1 == employee2);
        System.out.println(employee1.getAddress() == employee2.getAddress());

        System.out.println();
        System.out.println("After modifying address of employee 1");
        employee1.getAddress().setCity("Mumbai");

        System.out.println(employee1);
        System.out.println(employee2);
    }
}
