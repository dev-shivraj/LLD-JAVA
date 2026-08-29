package practice.isp.part2.employee.goodDesign;

public class Developer implements Employee {
    @Override
    public void work() {
        System.out.println("Developer is writing code");
    }

    @Override
    public void eat() {
        System.out.println("Developer is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Developer is sleeping");
    }
}