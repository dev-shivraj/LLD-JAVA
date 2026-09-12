package practice.decorator.part2.example2.component;

public class BasicDataProcessor implements DataProcessor {

    @Override
    public void process(String data) {
        System.out.println("Processing: " + data);
    }
}