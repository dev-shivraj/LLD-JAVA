package practice.observer.part2.practice2.subject;

import practice.observer.part2.practice2.observer.Observer;

import java.util.HashSet;
import java.util.Set;

public class WeatherStation implements Subject {

    private Set<Observer> observers = new HashSet<>();

    private double temperature;
    private double humidity;
    private double pressure;

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void setWeather(
            double temperature,
            double humidity,
            double pressure
    ) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        notifyObservers();
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPressure() {
        return pressure;
    }
}