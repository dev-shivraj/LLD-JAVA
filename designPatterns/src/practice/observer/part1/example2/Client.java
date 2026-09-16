package practice.observer.part1.example2;

import practice.observer.part1.example2.observer.MobileDisplay;
import practice.observer.part1.example2.observer.Observer;
import practice.observer.part1.example2.observer.WebDisplay;
import practice.observer.part1.example2.subject.WeatherStation;

public class Client {

    public static void main(String[] args) {

        WeatherStation weatherStation = new WeatherStation();

        Observer mobileDisplay = new MobileDisplay();
        Observer webDisplay = new WebDisplay();

        weatherStation.subscribe(mobileDisplay);
        weatherStation.subscribe(webDisplay);

        weatherStation.setTemperature(30.5f);
        System.out.println();

        weatherStation.setTemperature(32.0f);
        System.out.println();

        weatherStation.unsubscribe(webDisplay);
        weatherStation.setTemperature(29.5f);
    }
}