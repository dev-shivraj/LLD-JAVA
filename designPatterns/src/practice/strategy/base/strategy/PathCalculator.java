package practice.strategy.base.strategy;

import practice.strategy.base.component.Path;

public interface PathCalculator {

    Path calculate(String source, String dest);
}