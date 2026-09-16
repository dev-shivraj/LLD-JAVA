package practice.strategy.base.factory;

import practice.strategy.base.strategy.CarPathCalculator;
import practice.strategy.base.strategy.PathCalculator;
import practice.strategy.base.strategy.WalkPathCalculator;

import java.util.HashMap;
import java.util.Map;

public class PathCalculatorFactory {

    private static Map<String, PathCalculator> pathCalculatorRegistry = new HashMap<>();

    static {
        pathCalculatorRegistry.put("car", new CarPathCalculator());
        pathCalculatorRegistry.put("walk", new WalkPathCalculator());
    }

    public static PathCalculator getPathCalculator(String mode) {
       if(pathCalculatorRegistry.containsKey(mode)) return pathCalculatorRegistry.get(mode);

       throw new RuntimeException("mode not supported");
    }
}