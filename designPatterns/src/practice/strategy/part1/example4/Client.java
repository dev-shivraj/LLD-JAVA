package practice.strategy.part1.example4;

import practice.strategy.part1.example4.service.Sorter;
import practice.strategy.part1.example4.strategy.AscendingSortStrategy;
import practice.strategy.part1.example4.strategy.DescendingSortStrategy;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>(List.of(5, 2, 8, 1, 3));

        Sorter ascendingSorter = new Sorter(new AscendingSortStrategy());
        ascendingSorter.sort(numbers);
        System.out.println(numbers);


        numbers = new ArrayList<>(List.of(5, 2, 8, 1, 3));

        Sorter descendingSorter = new Sorter(new DescendingSortStrategy());
        descendingSorter.sort(numbers);
        System.out.println(numbers);
    }
}