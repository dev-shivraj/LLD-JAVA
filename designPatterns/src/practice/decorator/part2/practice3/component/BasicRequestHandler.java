package practice.decorator.part2.practice3.component;

public class BasicRequestHandler implements RequestHandler {

    @Override
    public void handle(String request) {
        System.out.println("Handling request: " + request);
    }
}