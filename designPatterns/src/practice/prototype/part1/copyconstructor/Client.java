package practice.prototype.part1.copyconstructor;

public class Client {

    public static void main(String[] args) {

        Employee employee1 = new Employee("Shivraj", "Engineering");
        Employee employee2 = new Employee(employee1);

        System.out.println(employee1);
        System.out.println(employee2);
    }
}