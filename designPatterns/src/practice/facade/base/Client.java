package practice.facade.base;

public class Client {

    public static void main(String[] args) {
        Amazon amazon = new Amazon();

        amazon.placeOrder(1,10);
    }
}