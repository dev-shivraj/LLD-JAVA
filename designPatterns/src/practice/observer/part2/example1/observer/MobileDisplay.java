package practice.observer.part2.example1.observer;

import practice.observer.part2.example1.subject.WeatherStation;

public class MobileDisplay implements Observer {
    private WeatherStation weatherStation;

    public MobileDisplay(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
    }

    @Override
    public void update() {
        float temperature = weatherStation.getTemperature();
        float humidity = weatherStation.getHumidity();

        System.out.println("Mobile Display: " + temperature + "°C, humidity = " + humidity + "%");
    }
}