package practice.observer.part2.practice1.observer;

public class EmailService implements Observer {

    @Override
    public void update(String event) {
        System.out.println("Email Service received: " + event);
    }
}