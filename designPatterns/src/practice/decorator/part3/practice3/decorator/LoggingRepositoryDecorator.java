package practice.decorator.part3.practice3.decorator;

import practice.decorator.part3.practice3.component.User;
import practice.decorator.part3.practice3.component.UserRepository;

public class LoggingRepositoryDecorator extends UserRepositoryDecorator {

    public LoggingRepositoryDecorator(UserRepository userRepository) {
        super(userRepository);
    }

    @Override
    public User findById(int id) {
        System.out.println("[LOG] Finding user: " + id);
        User user = userRepository.findById(id);
        System.out.println("[LOG] User found: " + user);

        return user;
    }
}