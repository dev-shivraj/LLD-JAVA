package practice.observer.part3.practice1.observer;

import practice.observer.part3.practice1.event.Event;

public interface Observer {

    void update(Event event);
}