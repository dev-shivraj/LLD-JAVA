package practice.decorator.part4.practice3;

import practice.decorator.part4.practice3.component.Controller;
import practice.decorator.part4.practice3.component.Handler;
import practice.decorator.part4.practice3.component.Request;
import practice.decorator.part4.practice3.decorator.AuthenticationMiddleware;
import practice.decorator.part4.practice3.decorator.LoggingMiddleware;
import practice.decorator.part4.practice3.decorator.RateLimitMiddleware;

public class Client {

    public static void main(String[] args) {

        Handler handler = new Controller();

        handler = new RateLimitMiddleware(handler, 2);
        handler = new AuthenticationMiddleware(handler);
        handler = new LoggingMiddleware(handler);

        Request request = new Request("shivraj", "/orders");

        handler.handle(request);
        handler.handle(request);
        handler.handle(request);
    }
}