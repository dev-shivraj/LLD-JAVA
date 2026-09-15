package practice.decorator.part4.example2.decorator;

import practice.decorator.part4.example2.component.Request;
import practice.decorator.part4.example2.component.RequestHandler;

public abstract class RequestHandlerDecorator implements RequestHandler {

    protected final RequestHandler requestHandler;

    protected RequestHandlerDecorator(RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    @Override
    public void handle(Request request) {
        requestHandler.handle(request);
    }
}