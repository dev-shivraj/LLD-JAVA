package practice.decorator.part4.practice3.component;

public class Controller implements Handler {

    @Override
    public void handle(Request request) {
        System.out.println("Controller processing: " + request.getEndpoint());
    }
}