package practice.prototype.part1.shallowcopy;

public class Client {
    public static void main(String[] args) {
        // ============================================================================================

        Address address = new Address("Bangalore");
        Employee employee1 = new Employee("Raj", address);

        // shallow copy
        Employee employee2 = employee1.shallowCopy();

        System.out.println(employee1);
        System.out.println(employee2);

        System.out.println("DEBUG");

        System.out.println();

        employee2.getAddress().setCity("Mumbai");

        System.out.println("After modification:");
        employee2.setAddress(new Address("Mumbai"));
        System.out.println(employee1);
        System.out.println(employee2);

        System.out.println("DEBUG");


        // ============================================================================================
    }
}
