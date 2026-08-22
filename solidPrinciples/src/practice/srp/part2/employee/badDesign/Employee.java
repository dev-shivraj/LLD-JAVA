package practice.srp.part2.employee.badDesign;

public class Employee {

    // Group 1 : employee salary related responsibility
    public void calculateSalary() {
        System.out.println("Calculating salary");
    }

    // Group 1 : employee salary related responsibility
    public void calculateBonus() {
        System.out.println("Calculating bonus");
    }

    // Group 1 : employee salary related responsibility
    public void calculateTax() {
        System.out.println("Calculating tax");
    }

    // seems like same responsibility as above but it's printing responsibility
    // it makes less cohesion
    // printing responsibility
    public void printSalarySlip() {
        System.out.println("Printing salary slip");
    }

    // persistence responsibility
    public void saveToDatabase() {
        System.out.println("Saving to database");
    }

    // report responsibility
    public void generateReport() {
        System.out.println("Generating Report");
    }

    // communication responsibility
    public void sendEmail() {
        System.out.println("Sending Email");
    }
}