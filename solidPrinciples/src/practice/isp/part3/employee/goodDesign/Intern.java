package practice.isp.part3.employee.goodDesign;

public class Intern implements Employee {
    @Override
    public void work() {
        System.out.println("Intern is working");
    }

    @Override
    public void eat() {
        System.out.println("Intern is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Intern is sleeping");
    }
}