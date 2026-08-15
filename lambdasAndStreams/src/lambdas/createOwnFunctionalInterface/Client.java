package lambdas.createOwnFunctionalInterface;

public class Client {
    public static void main(String[] args) {
        AdderWithoutLambdas adderWithoutLambdas = new AdderWithoutLambdas();
        int result = adderWithoutLambdas.calculate(1, 2, 3);
        System.out.println("Result without lambdas: " + result);


        // using lambda expression to implement the same functionality
        Calculator adderWithLambdas = (a, b, c) -> a + b + c;
        int resultWithLambdas = adderWithLambdas.calculate(1, 2, 3);
        System.out.println("Result with lambdas: " + resultWithLambdas);
    }
}
