package practice.observer.part1.example1.observer;

public class YouTubeSubscriber implements Observer {

    private String name;

    public YouTubeSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println(name + " received notification: New video - " + videoTitle);
    }
}