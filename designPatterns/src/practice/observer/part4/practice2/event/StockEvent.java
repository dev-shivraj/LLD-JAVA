package practice.observer.part4.practice2.event;

public class StockEvent {

    private String symbol;
    private double oldPrice;
    private double newPrice;

    public StockEvent(String symbol, double oldPrice, double newPrice) {
        this.symbol = symbol;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public double getNewPrice() {
        return newPrice;
    }
}