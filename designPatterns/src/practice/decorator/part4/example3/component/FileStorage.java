package practice.decorator.part4.example3.component;

public class FileStorage implements DataProcessor {

    @Override
    public void process(String data) {
        System.out.println("Storing data: " + data);
    }
}