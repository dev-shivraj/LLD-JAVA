package practice.observer.part2.practice2.observer;

import practice.observer.part2.practice2.subject.WeatherStation;

public class MobileDisplay implements Observer {

    private WeatherStation weatherStation;

    public MobileDisplay(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
    }

    @Override
    public void update() {
        System.out.println("Mobile: " + weatherStation.getTemperature() + "°C");
    }
}