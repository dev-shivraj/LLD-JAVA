package practice.prototype.part2.prototypepattern.employee;

public class Client {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Shivraj", "IT", "Senior Software Engineer");
        Employee employee2 = employee1.copy();

        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(employee1 == employee2);

        employee2.setName("Rahul");
        employee2.setDesignation("Software Developer");


        System.out.println();
        System.out.println(employee1);
        System.out.println(employee2);
    }
}
