package practice.observer.part2.example1.subject;

import practice.observer.part2.example1.observer.Observer;

import java.util.HashSet;
import java.util.Set;

public class WeatherStation implements Subject {
    private Set<Observer> observers = new HashSet<>();
    private float temperature;
    private float humidity;

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

    public void setWeather(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;

        notifyObservers();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }
}