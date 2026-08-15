package lambdas.createOwnFunctionalInterface;

public class AdderWithoutLambdas implements Calculator {
    @Override
    public int calculate(int a, int b, int c) {
        return a + b + c;
    }
}
