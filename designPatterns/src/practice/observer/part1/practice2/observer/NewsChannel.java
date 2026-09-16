package practice.observer.part1.practice2.observer;

public class NewsChannel implements Observer {

    private String name;

    public NewsChannel(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " received news: " + news);
    }
}