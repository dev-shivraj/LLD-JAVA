package practice.dip.part1.employee.goodDesign;

public class MySQLEmployeeRepository implements EmployeeRepository {

    @Override
    public void save(Employee employee) {
        System.out.println("Saving employee " + employee.getName() + " to MySQL");
    }
}