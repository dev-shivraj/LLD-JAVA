package practice.observer.part1.practice2.subject;

import practice.observer.part1.practice2.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency {

    private List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void publishNews(String news) {
        System.out.println("Breaking News: " + news);
        notifyObservers(news);
    }

    private void notifyObservers(String news) {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }
}