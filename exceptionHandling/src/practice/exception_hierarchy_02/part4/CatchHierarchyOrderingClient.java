package practice.exception_hierarchy_02.part4;

public class CatchHierarchyOrderingClient {
    public static void main(String[] args) {
        // ==============================================================================
//        try {
//            System.out.println("A");
//
//            System.out.println(10 / 0);
//
//            System.out.println("A");
//        } catch (RuntimeException e) {
//            System.out.println("Exception catched: " + e.getMessage());
//        }
////        catch (ArithmeticException e) {
////            System.out.println("Exception catched: " + e.getMessage());
////        }

        // ==============================================================================

//        try {
//            System.out.println("A");
//
//            System.out.println(10 / 0);
//
//            System.out.println("A");
//        } catch (ArithmeticException e) {
//            System.out.println("Exception catched: " + e.getMessage());
//        }
//        catch (RuntimeException e) {
//            System.out.println("Exception catched: " + e.getMessage());
//        }

        // ==============================================================================

        try {
            System.out.println("A");

            System.out.println(10 / 0);

            System.out.println("A");
        } catch (Exception e) {
            System.out.println("Exception catched: " + e.getMessage());
        }
//        catch (RuntimeException e) {
//            System.out.println("ArithmeticException catched: " + e.getMessage());
//        }

        // ==============================================================================
    }
}
