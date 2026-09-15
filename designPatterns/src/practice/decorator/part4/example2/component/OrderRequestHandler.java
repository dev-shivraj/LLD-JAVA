package practice.decorator.part4.example2.component;

public class OrderRequestHandler implements RequestHandler {

    @Override
    public void handle(Request request) {
        System.out.println("Processing order action: " + request.getAction());
    }
}