package practice.decorator.part1.practice2.component;

public class BasicDataService implements DataService {

    @Override
    public void process(String data) {
        System.out.println("Processing data: " + data);
    }
}