package practice.observer.part2.practice2.observer;

import practice.observer.part2.practice2.subject.WeatherStation;

public class WebDisplay implements Observer {

    private WeatherStation weatherStation;

    public WebDisplay(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
    }

    @Override
    public void update() {
        System.out.println("Web: " + weatherStation.getTemperature() + "°C, humidity = " + weatherStation.getHumidity() + "%, pressure = " + weatherStation.getPressure());
    }
}