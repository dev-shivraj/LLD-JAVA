package practice.strategy.part1.example4.service;

import practice.strategy.part1.example4.strategy.SortStrategy;

import java.util.List;

public class Sorter {

    private final SortStrategy sortStrategy;

    public Sorter(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void sort(List<Integer> numbers) {
        sortStrategy.sort(numbers);
    }
}