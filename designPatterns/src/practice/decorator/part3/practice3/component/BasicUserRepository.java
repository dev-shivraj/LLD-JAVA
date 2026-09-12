package practice.decorator.part3.practice3.component;

public class BasicUserRepository implements UserRepository {

    @Override
    public User findById(int id) {
        System.out.println("[DB] Fetching user from database");
        return new User(id, "Shivraj");
    }
}