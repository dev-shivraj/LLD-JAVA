package practice.decorator.part4.practice3.decorator;

import practice.decorator.part4.practice3.component.Handler;
import practice.decorator.part4.practice3.component.Request;

public class AuthenticationMiddleware extends HandlerDecorator {

    public AuthenticationMiddleware(Handler handler) {
        super(handler);
    }

    @Override
    public void handle(Request request) {

        if (request.getUsername() == null || request.getUsername().isBlank()) {
            throw new RuntimeException("Authentication failed");
        }

        System.out.println("[AUTH] Authentication successful");

        handler.handle(request);
    }
}