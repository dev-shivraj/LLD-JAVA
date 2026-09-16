package practice.observer.base;

import practice.observer.base.observer.IPhoneUI;
import practice.observer.base.observer.MacUI;
import practice.observer.base.subject.WeatherService;

public class Client {

    public static void main(String[] args) {
        WeatherService weatherService = new WeatherService(30);

        IPhoneUI shivrajIphone = new IPhoneUI(weatherService);
        MacUI shivrajMac = new MacUI(weatherService);

        weatherService.updateTemp();
        System.out.println();


        weatherService.unsubscribe(shivrajIphone);
        weatherService.updateTemp();
    }
}