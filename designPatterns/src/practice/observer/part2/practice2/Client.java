package practice.observer.part2.practice2;

import practice.observer.part2.practice2.observer.MobileDisplay;
import practice.observer.part2.practice2.observer.Observer;
import practice.observer.part2.practice2.observer.TVDisplay;
import practice.observer.part2.practice2.observer.WebDisplay;
import practice.observer.part2.practice2.subject.WeatherStation;

public class Client {

    public static void main(String[] args) {

        WeatherStation weatherStation = new WeatherStation();

        Observer mobile = new MobileDisplay(weatherStation);
        Observer tv = new TVDisplay(weatherStation);
        Observer web = new WebDisplay(weatherStation);

        weatherStation.subscribe(mobile);
        weatherStation.subscribe(tv);
        weatherStation.subscribe(web);

        weatherStation.setWeather(30, 65, 1012);
        System.out.println();

        weatherStation.unsubscribe(tv);
        weatherStation.setWeather(32, 70, 1010);
    }
}