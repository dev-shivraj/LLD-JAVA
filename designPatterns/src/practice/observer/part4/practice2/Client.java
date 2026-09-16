package practice.observer.part4.practice2;

import practice.observer.part4.practice2.observer.Investor;
import practice.observer.part4.practice2.observer.Observer;
import practice.observer.part4.practice2.observer.PriceLogger;
import practice.observer.part4.practice2.observer.TradingDashboard;
import practice.observer.part4.practice2.subject.Stock;

public class Client {

    public static void main(String[] args) {

        Stock stock = new Stock("AAPL", 200);

        Observer rahul = new Investor("Rahul");
        Observer dashboard = new TradingDashboard();
        Observer logger = new PriceLogger();

        stock.subscribe(rahul);
        stock.subscribe(dashboard);
        stock.subscribe(logger);

        stock.setPrice(205);
        System.out.println();

        stock.setPrice(198);
        System.out.println();

        stock.unsubscribe(rahul);
        stock.setPrice(210);
    }
}