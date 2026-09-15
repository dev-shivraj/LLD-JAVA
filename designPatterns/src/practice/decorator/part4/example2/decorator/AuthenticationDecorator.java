package practice.decorator.part4.example2.decorator;

import practice.decorator.part4.example2.component.Request;
import practice.decorator.part4.example2.component.RequestHandler;

public class AuthenticationDecorator extends RequestHandlerDecorator {

    public AuthenticationDecorator(RequestHandler requestHandler) {
        super(requestHandler);
    }

    @Override
    public void handle(Request request) {
        System.out.println("Checking authentication...");

        if (request.getUsername() == null || request.getUsername().isBlank()) {
            throw new RuntimeException("User is not authenticated");
        }

        requestHandler.handle(request);
    }
}