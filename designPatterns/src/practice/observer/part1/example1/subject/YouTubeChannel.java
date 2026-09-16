package practice.observer.part1.example1.subject;

import practice.observer.part1.example1.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class YouTubeChannel {
    private List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void uploadVideo(String videoTitle) {
        System.out.println("New video uploaded: " + videoTitle);
        notifyObservers(videoTitle);
    }

    private void notifyObservers(String videoTitle) {
        for (Observer observer : observers) {
            observer.update(videoTitle);
        }
    }
}