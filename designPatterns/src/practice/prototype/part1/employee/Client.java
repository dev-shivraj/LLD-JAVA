package practice.prototype.part1.employee;

public class Client {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Shivraj", "Engineering", "Developer");
        Employee employee2 = employee1.copy();

        employee2.setName("Raj");
        employee2.setDesignation("Senior Software Engineer");

        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(employee1 == employee2);
    }
}
