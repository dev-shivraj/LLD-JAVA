package practice.ocp.part4.employee.badDesign;

public class EmployeeSalaryCalculator {

    public double calculate(String type, double salary) {

        if (type.equals("FULL_TIME")) {
            return salary + 1000;
        } else if (type.equals("CONTRACT")) {
            return salary;
        } else if (type.equals("INTERN")) {
            return salary * 0.5;
        }

        return 0;
    }
}