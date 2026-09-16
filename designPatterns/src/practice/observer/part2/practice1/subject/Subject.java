package practice.observer.part2.practice1.subject;

import practice.observer.part2.practice1.observer.Observer;

public interface Subject {

    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObservers(String event);
}