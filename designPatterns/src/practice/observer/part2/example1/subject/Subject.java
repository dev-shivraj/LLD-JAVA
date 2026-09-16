package practice.observer.part2.example1.subject;

import practice.observer.part2.example1.observer.Observer;

public interface Subject {

    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObservers();
}