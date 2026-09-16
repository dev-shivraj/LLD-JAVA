package practice.strategy.base.strategy;

import practice.strategy.base.component.Path;

public class CarPathCalculator implements PathCalculator{
    @Override
    public Path calculate(String source, String dest) {
        System.out.println("Travelling via CAR");
        return new Path(5,2.5);
    }


}