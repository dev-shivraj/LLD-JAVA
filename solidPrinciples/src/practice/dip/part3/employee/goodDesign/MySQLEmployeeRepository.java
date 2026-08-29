package practice.dip.part3.employee.goodDesign;

public class MySQLEmployeeRepository implements EmployeeRepository {
    @Override
    public void save(String employee) {
        System.out.println("Saving " + employee + " to MySQL");
    }
}