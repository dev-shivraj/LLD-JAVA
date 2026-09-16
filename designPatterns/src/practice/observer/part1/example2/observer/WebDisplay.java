package practice.observer.part1.example2.observer;

public class WebDisplay implements Observer {

    @Override
    public void update(float temperature) {
        System.out.println("Web Display: Temperature = " + temperature + "°C");
    }
}