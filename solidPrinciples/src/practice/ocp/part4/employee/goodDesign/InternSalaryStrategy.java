package practice.ocp.part4.employee.goodDesign;

public class InternSalaryStrategy implements SalaryCalculationStrategy {

    @Override
    public double calculate(double salary) {
        return salary * 0.5;
    }
}