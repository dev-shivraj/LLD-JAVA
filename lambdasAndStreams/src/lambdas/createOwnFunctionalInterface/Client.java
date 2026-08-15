package lambdas.createOwnFunctionalInterface;

public class Client {
    public static void main(String[] args) {
        AdderWithoutLambdas adderWithoutLambdas = new AdderWithoutLambdas();
        int result = adderWithoutLambdas.calculate(1, 2, 3);
        System.out.println("Result without lambdas: " + result);
    }
}
