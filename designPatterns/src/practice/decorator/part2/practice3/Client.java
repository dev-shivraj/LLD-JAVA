package practice.decorator.part2.practice3;

import practice.decorator.part2.practice3.component.BasicRequestHandler;
import practice.decorator.part2.practice3.component.RequestHandler;
import practice.decorator.part2.practice3.decorator.AuthenticationDecorator;
import practice.decorator.part2.practice3.decorator.AuthorizationDecorator;
import practice.decorator.part2.practice3.decorator.LoggingDecorator;

public class Client {

    public static void main(String[] args) {

        RequestHandler handler = new BasicRequestHandler();

        handler = new AuthenticationDecorator(handler);
        handler = new AuthorizationDecorator(handler);
        handler = new LoggingDecorator(handler);

        handler.handle("GET /users");
    }
}