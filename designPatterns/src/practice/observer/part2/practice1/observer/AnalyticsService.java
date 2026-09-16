package practice.observer.part2.practice1.observer;

public class AnalyticsService implements Observer {

    @Override
    public void update(String event) {
        System.out.println("Analytics Service received: " + event);
    }
}