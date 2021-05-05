//package exceptions;
//
//public class ClassWork {
//    static private String s;
//
//    public static void main(String[] args) {
//
//        calculate(0, 2);
//        length("");
//    }
//
//    private static void length(String s) {
//        try {
//            int i = s.length();
//        } catch( Exception e ) {
//            if (e instanceof NullPointerException) {
//                NullPointerException npe = (NullPointerException) e;
//            }
//        }
//    }
//
//    private static void calculate(int i, int j) {
//        try {
//            int k = j % i;
//        } catch (ArithmeticException ae) {
//            System.out.println("i = 0");
//        }
//    }
//}
//
