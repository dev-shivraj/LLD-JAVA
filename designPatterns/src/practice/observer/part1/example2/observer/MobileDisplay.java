package practice.observer.part1.example2.observer;

public class MobileDisplay implements Observer {

    @Override
    public void update(float temperature) {
        System.out.println("Mobile Display: Temperature = " + temperature + "°C");
    }
}