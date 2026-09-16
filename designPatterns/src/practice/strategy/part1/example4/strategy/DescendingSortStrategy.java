package practice.strategy.part1.example4.strategy;

import java.util.Collections;
import java.util.List;

public class DescendingSortStrategy implements SortStrategy {

    @Override
    public void sort(List<Integer> numbers) {
        numbers.sort(Collections.reverseOrder());
    }
}