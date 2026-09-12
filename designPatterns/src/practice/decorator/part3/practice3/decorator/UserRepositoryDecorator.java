package practice.decorator.part3.practice3.decorator;

import practice.decorator.part3.practice3.component.User;
import practice.decorator.part3.practice3.component.UserRepository;

public abstract class UserRepositoryDecorator implements UserRepository {

    protected UserRepository userRepository;

    protected UserRepositoryDecorator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }
}