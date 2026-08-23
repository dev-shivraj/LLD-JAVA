package practice.ocp.part4.employee.goodDesign;

public class ContractSalaryStrategy implements SalaryCalculationStrategy {

    @Override
    public double calculate(double salary) {
        return salary;
    }
}