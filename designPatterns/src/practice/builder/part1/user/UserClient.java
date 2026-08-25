package practice.builder.part1.user;

public class UserClient {
    public static void main(String[] args) {
        User user = new UserBuilder()
                .setName("Shivraj")
                .setAge(27)
                .setEmail("shivraj@gmail.com")
                .build();

        System.out.println(user);
    }
}
