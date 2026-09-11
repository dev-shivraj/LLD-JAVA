package practice.decorator.practice2.service;

public class BasicDataService implements DataService {

    @Override
    public void process(String data) {
        System.out.println("Processing data: " + data);
    }
}