package practice.decorator.part4.practice3.decorator;

import practice.decorator.part4.practice3.component.Handler;
import practice.decorator.part4.practice3.component.Request;

public class RateLimitMiddleware extends HandlerDecorator {

    private int requestCount;

    private final int maxRequests;

    public RateLimitMiddleware(Handler handler, int maxRequests) {
        super(handler);
        this.maxRequests = maxRequests;
    }

    @Override
    public void handle(Request request) {
        requestCount++;

        if (requestCount > maxRequests) {
            throw new RuntimeException("Rate limit exceeded");
        }

        System.out.println("[RATE LIMIT] Request accepted");

        handler.handle(request);
    }
}