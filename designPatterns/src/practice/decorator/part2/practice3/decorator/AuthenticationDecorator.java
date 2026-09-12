package practice.decorator.part2.practice3.decorator;

import practice.decorator.part2.practice3.component.RequestHandler;

public class AuthenticationDecorator extends RequestHandlerDecorator {

    public AuthenticationDecorator(RequestHandler requestHandler) {
        super(requestHandler);
    }

    @Override
    public void handle(String request) {
        System.out.println("[AUTH] User authenticated");
        requestHandler.handle(request);
    }
}