package practice.decorator.part2.practice3.decorator;

import practice.decorator.part2.practice3.component.RequestHandler;

public class LoggingDecorator extends RequestHandlerDecorator {

    public LoggingDecorator(RequestHandler requestHandler) {
        super(requestHandler);
    }

    @Override
    public void handle(String request) {
        System.out.println("[LOG] Request received: " + request);
        requestHandler.handle(request);
        System.out.println("[LOG] Request completed");
    }
}