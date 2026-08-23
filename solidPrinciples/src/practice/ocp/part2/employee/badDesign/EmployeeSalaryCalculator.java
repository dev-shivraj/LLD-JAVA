package practice.ocp.part2.employee.badDesign;

public class EmployeeSalaryCalculator {

    public double calculateSalary(String employeeType, double salary) {
        if (employeeType.equals("FULL_TIME")) {
            return salary + 1000;
        } else if (employeeType.equals("CONTRACT")) {
            return salary;
        } else if (employeeType.equals("INTERN")) {
            return salary * 0.5;
        }
        return 0;
    }
}