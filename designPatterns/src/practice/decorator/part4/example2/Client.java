package practice.decorator.part4.example2;

import practice.decorator.part4.example2.component.OrderRequestHandler;
import practice.decorator.part4.example2.component.Request;
import practice.decorator.part4.example2.component.RequestHandler;
import practice.decorator.part4.example2.decorator.AuthenticationDecorator;
import practice.decorator.part4.example2.decorator.AuthorizationDecorator;
import practice.decorator.part4.example2.decorator.LoggingDecorator;

public class Client {

    public static void main(String[] args) {
        RequestHandler handler = new OrderRequestHandler();

        handler = new AuthorizationDecorator(handler);
        handler = new AuthenticationDecorator(handler);
        handler = new LoggingDecorator(handler);

        Request request = new Request("shivraj", "ADMIN", "CREATE_ORDER");

        handler.handle(request);
    }
}