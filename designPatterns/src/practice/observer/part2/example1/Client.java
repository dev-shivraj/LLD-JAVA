package practice.observer.part2.example1;

import practice.observer.part2.example1.observer.MobileDisplay;
import practice.observer.part2.example1.observer.Observer;
import practice.observer.part2.example1.subject.WeatherStation;

public class Client {

    public static void main(String[] args) {

        WeatherStation weatherStation = new WeatherStation();
        Observer mobileDisplay = new MobileDisplay(weatherStation);

        weatherStation.subscribe(mobileDisplay);

        weatherStation.setWeather(30.5f, 65.0f);
        System.out.println();

        weatherStation.setWeather(32.0f, 70.0f);
    }
}