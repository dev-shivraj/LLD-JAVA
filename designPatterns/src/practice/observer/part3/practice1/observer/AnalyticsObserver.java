package practice.observer.part3.practice1.observer;

import practice.observer.part3.practice1.event.Event;

public class AnalyticsObserver implements Observer {

    @Override
    public void update(Event event) {
        System.out.println("Analytics recorded: " + event.getType() + " -> " + event.getData());
    }
}