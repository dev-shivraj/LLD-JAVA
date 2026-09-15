package practice.decorator.part4.practice3.decorator;

import practice.decorator.part4.practice3.component.Handler;
import practice.decorator.part4.practice3.component.Request;

public class LoggingMiddleware extends HandlerDecorator {

    public LoggingMiddleware(Handler handler) {
        super(handler);
    }

    @Override
    public void handle(Request request) {
        System.out.println("[LOG] " + request.getEndpoint());
        handler.handle(request);
    }
}