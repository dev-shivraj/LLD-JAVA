package practice.decorator.part2.practice3.decorator;

import practice.decorator.part2.practice3.component.RequestHandler;

public abstract class RequestHandlerDecorator implements RequestHandler {

    protected RequestHandler requestHandler;

    protected RequestHandlerDecorator(RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    @Override
    public void handle(String request) {
        requestHandler.handle(request);
    }
}