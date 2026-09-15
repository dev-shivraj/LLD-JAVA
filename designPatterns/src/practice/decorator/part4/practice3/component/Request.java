package practice.decorator.part4.practice3.component;

public class Request {

    private final String username;
    private final String endpoint;

    public Request(String username, String endpoint) {
        this.username = username;
        this.endpoint = endpoint;
    }

    public String getUsername() {
        return username;
    }

    public String getEndpoint() {
        return endpoint;
    }
}