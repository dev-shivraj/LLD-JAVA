package practice.observer.part1.example1;

import practice.observer.part1.example1.observer.Observer;
import practice.observer.part1.example1.observer.YouTubeSubscriber;
import practice.observer.part1.example1.subject.YouTubeChannel;

public class Client {

    public static void main(String[] args) {

        YouTubeChannel channel = new YouTubeChannel();

        Observer shivraj = new YouTubeSubscriber("Shivraj");
        Observer rahul = new YouTubeSubscriber("Rahul");
        Observer amit = new YouTubeSubscriber("Amit");

        channel.subscribe(shivraj);
        channel.subscribe(rahul);
        channel.subscribe(amit);

        channel.uploadVideo("Observer Design Pattern");
        System.out.println();

        channel.unsubscribe(rahul);
        channel.uploadVideo("Strategy Design Pattern");
    }
}