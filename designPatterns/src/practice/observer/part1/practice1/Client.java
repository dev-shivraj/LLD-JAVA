package practice.observer.part1.practice1;

import practice.observer.part1.practice1.observer.Investor;
import practice.observer.part1.practice1.observer.Observer;
import practice.observer.part1.practice1.subject.Stock;

public class Client {

    public static void main(String[] args) {

        Stock stock = new Stock();

        Observer rahul = new Investor("Rahul");
        Observer amit = new Investor("Amit");

        stock.subscribe(rahul);
        stock.subscribe(amit);

        stock.setPrice(150);
        System.out.println();

        stock.unsubscribe(amit);
        stock.setPrice(175);
    }
}