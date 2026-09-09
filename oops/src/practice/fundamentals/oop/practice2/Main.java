package practice.fundamentals.oop.practice2;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.name = "Raj";
        employee1.employeeId = "E101";
        employee1.salary = 50000;
        employee1.department = "Engineering";

        Employee employee2 = new Employee();
        employee2.name = "Priya";
        employee2.employeeId = "E102";
        employee2.salary = 60000;
        employee2.department = "HR";

        employee1.displayInfo();
        employee1.work();
        employee1.takeLeave();

        System.out.println();

        employee2.displayInfo();
        employee2.work();
        employee2.takeLeave();
    }
}
