package practice.ocp.part4.employee.goodDesign;

public class EmployeeSalaryCalculator {

    public double calculate(SalaryCalculationStrategy strategy, double salary) {
        return strategy.calculate(salary);
    }
}