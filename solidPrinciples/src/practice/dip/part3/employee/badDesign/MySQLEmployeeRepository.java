package practice.dip.part3.employee.badDesign;

public class MySQLEmployeeRepository {

    public void save(String employee) {

        System.out.println(
                "Saving " + employee + " to MySQL"
        );
    }
}