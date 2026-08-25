package practice.builder.part1.user;

public class UserBuilder {
    private String name;
    private int age;
    private String email;

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public User build() {
        return new User(name, age, email);
    }
}
