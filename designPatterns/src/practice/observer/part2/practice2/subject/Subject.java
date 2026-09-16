package practice.observer.part2.practice2.subject;

import practice.observer.part2.practice2.observer.Observer;

public interface Subject {

    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObservers();
}