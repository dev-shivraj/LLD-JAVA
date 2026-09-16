package practice.observer.part1.practice2;

import practice.observer.part1.practice2.observer.NewsChannel;
import practice.observer.part1.practice2.observer.Observer;
import practice.observer.part1.practice2.subject.NewsAgency;

public class Client {

    public static void main(String[] args) {

        NewsAgency agency = new NewsAgency();

        Observer cnn = new NewsChannel("CNN");
        Observer bbc = new NewsChannel("BBC");
        Observer ndtv = new NewsChannel("NDTV");

        agency.subscribe(cnn);
        agency.subscribe(bbc);
        agency.subscribe(ndtv);

        agency.publishNews("Observer Pattern is powerful!");
        System.out.println();

        agency.unsubscribe(bbc);
        agency.publishNews("Java Design Patterns are important for LLD.");
    }
}