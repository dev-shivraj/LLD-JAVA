package practice.strategy.base.service;

import practice.strategy.base.component.Path;
import practice.strategy.base.strategy.PathCalculator;
import practice.strategy.base.factory.PathCalculatorFactory;

public class GoogleMap {

    private PathCalculator pathCalculator;

    public GoogleMap(String mode) {
        this.pathCalculator = PathCalculatorFactory.getPathCalculator(mode);
    }

    public Path calculatePath(String source, String destination) {
        // pre prcessings
        return pathCalculator.calculate(source,destination);
    }
}