package practice.fundamentals_01.part2;

public class CatchOrderingClient {
    public static void main(String[] args) {
        // ================================================================================
        try {

            System.out.println("A");
            int a = 10 / 0;
            System.out.println("A");
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
//        catch (ArithmeticException e) {
//            System.out.println("Arithmetic exception : " + e.getMessage());
//        }

        // ================================================================================

        try {
            System.out.println("1");
            int a = 10 / 0;
            System.out.println("2");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException : " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException : " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        } finally {
            System.out.println("Inside finally : 2");
        }

        System.out.println("Outside try, catch finally : 3");

        // ================================================================================
    }
}
