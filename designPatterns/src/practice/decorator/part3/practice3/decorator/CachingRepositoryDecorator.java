package practice.decorator.part3.practice3.decorator;

import practice.decorator.part3.practice3.component.User;
import practice.decorator.part3.practice3.component.UserRepository;

import java.util.HashMap;
import java.util.Map;

public class CachingRepositoryDecorator extends UserRepositoryDecorator {

    private final Map<Integer, User> cache = new HashMap<>();

    public CachingRepositoryDecorator(UserRepository userRepository) {
        super(userRepository);
    }

    @Override
    public User findById(int id) {
        if (cache.containsKey(id)) {
            System.out.println("[CACHE] User found in cache");

            return cache.get(id);
        }

        System.out.println("[CACHE] User not found in cache");

        User user = userRepository.findById(id);
        cache.put(id, user);
        return user;
    }
}