package practice.decorator.part2.practice3.decorator;

import practice.decorator.part2.practice3.component.RequestHandler;

public class AuthorizationDecorator extends RequestHandlerDecorator {

    public AuthorizationDecorator(RequestHandler requestHandler) {
        super(requestHandler);
    }

    @Override
    public void handle(String request) {
        System.out.println("[AUTHORIZATION] Access granted");
        requestHandler.handle(request);
    }
}