package practice.decorator.part4.practice3.decorator;

import practice.decorator.part4.practice3.component.Handler;
import practice.decorator.part4.practice3.component.Request;

public abstract class HandlerDecorator implements Handler {

    protected final Handler handler;

    protected HandlerDecorator(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void handle(Request request) {
        handler.handle(request);
    }
}