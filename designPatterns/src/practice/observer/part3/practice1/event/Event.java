package practice.observer.part3.practice1.event;

public class Event {

    private EventType type;
    private String data;

    public Event(EventType type, String data) {
        this.type = type;
        this.data = data;
    }

    public EventType getType() {
        return type;
    }

    public String getData() {
        return data;
    }
}