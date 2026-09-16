package practice.observer.part2.example2.observer;

public class AnalyticsService implements Observer {

    @Override
    public void update(String orderId, String status) {
        System.out.println("Analytics recorded: " + orderId + " -> " + status);
    }
}