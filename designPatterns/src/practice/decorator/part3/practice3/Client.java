package practice.decorator.part3.practice3;

import practice.decorator.part3.practice3.component.BasicUserRepository;
import practice.decorator.part3.practice3.component.UserRepository;
import practice.decorator.part3.practice3.decorator.CachingRepositoryDecorator;
import practice.decorator.part3.practice3.decorator.LoggingRepositoryDecorator;

public class Client {

    public static void main(String[] args) {
        UserRepository repository = new BasicUserRepository();
        repository = new CachingRepositoryDecorator(repository);
        repository = new LoggingRepositoryDecorator(repository);

        System.out.println(repository.findById(1));
        System.out.println();
        System.out.println(repository.findById(1));
    }
}