package practice.registry.part1.basic.service;

public class EmailService implements Service {
    @Override
    public void execute() {
        System.out.println("Executing Email Service");
    }
}