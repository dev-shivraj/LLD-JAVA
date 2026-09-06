package practice.registry.part1.basic.service;

public class SmsService implements Service {
    @Override
    public void execute() {
        System.out.println("Executing SMS Service");
    }
}