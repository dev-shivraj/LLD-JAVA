package practice.ocp.part4.employee.goodDesign;

public class FullTimeSalaryStrategy implements SalaryCalculationStrategy {

    @Override
    public double calculate(double salary) {
        return salary + 1000;
    }
}