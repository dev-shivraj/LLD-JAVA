package practice.decorator.part4.example2.decorator;

import practice.decorator.part4.example2.component.Request;
import practice.decorator.part4.example2.component.RequestHandler;

public class AuthorizationDecorator extends RequestHandlerDecorator {

    public AuthorizationDecorator(RequestHandler requestHandler) {
        super(requestHandler);
    }

    @Override
    public void handle(Request request) {

        System.out.println("Checking authorization...");

        if (!"ADMIN".equals(request.getRole())) {
            throw new RuntimeException("Access denied");
        }

        requestHandler.handle(request);
    }
}