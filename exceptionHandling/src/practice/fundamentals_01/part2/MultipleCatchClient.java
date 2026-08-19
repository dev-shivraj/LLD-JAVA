package practice.fundamentals_01.part2;

public class MultipleCatchClient {
    public static void main(String[] args) {
        // ========================================================================
//        try {
//            System.out.println("A");
//
//            String s = "Shivraj";
////            int res = Integer.parseInt(s);
//            System.out.println(10 / 0);
//
//            System.out.println("A");
//
//        } catch (ArithmeticException e) {
//            System.out.println("Arithmetic exception : " + e);
//        } catch (NumberFormatException e) {
//            System.out.println("Number format exception : " + e);
//        }

        // ========================================================================

        try {
            System.out.println("A");

            String s = "Shivraj";
            int res = Integer.parseInt(s);
//            System.out.println(10 / 0);

            System.out.println("B");

        } catch (ArithmeticException | NumberFormatException e) {
            System.out.println("Arithmetic exception : " + e);
        } finally {
            System.out.println("C");
        }

        System.out.println("D");

        // ========================================================================
    }
}
