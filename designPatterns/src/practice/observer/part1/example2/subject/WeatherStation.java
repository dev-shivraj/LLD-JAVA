package practice.observer.part1.example2.subject;

import practice.observer.part1.example2.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation {

    private List<Observer> observers = new ArrayList<>();

    private float temperature;

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}