package practice.dip.part1.employee.badDesign;

public class MySQLEmployeeRepository {
    public void save(Employee employee) {
        System.out.println("Saving employee " + employee.getName() + " to MySQL");
    }
}