package practice.decorator.part4.example2.component;

public class Request {

    private final String username;
    private final String role;
    private final String action;

    public Request(String username, String role, String action) {
        this.username = username;
        this.role = role;
        this.action = action;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public String getAction() {
        return action;
    }
}