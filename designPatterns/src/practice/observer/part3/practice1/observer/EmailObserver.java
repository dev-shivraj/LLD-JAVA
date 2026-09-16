package practice.observer.part3.practice1.observer;

import practice.observer.part3.practice1.event.Event;

public class EmailObserver implements Observer {

    @Override
    public void update(Event event) {
        System.out.println("Email received event: " + event.getType() + " -> " + event.getData());
    }
}