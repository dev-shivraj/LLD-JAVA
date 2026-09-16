package practice.observer.part2.practice2.observer;

import practice.observer.part2.practice2.subject.WeatherStation;

public class TVDisplay implements Observer {

    private WeatherStation weatherStation;

    public TVDisplay(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
    }

    @Override
    public void update() {
        System.out.println("TV: " + weatherStation.getTemperature() + "°C, humidity = " + weatherStation.getHumidity() + "%");
    }
}