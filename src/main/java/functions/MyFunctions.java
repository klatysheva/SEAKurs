package functions;

public class MyFunctions {
    static boolean isEven (int num) {
        if (num == 0) {
            System.out.println("It's 0!");
            return false;
        }
        else if (num%2==0) {
            System.out.println("It's an even number!");
            return true;
        }
        else if (num%2!=0){
            System.out.println("It's an odd number!");
            return false;
        }
        else {
            System.out.println("Something went wrong");
            return false;
        }
    }
    static double hyperbola(int a) {
        return 1 / (double)a;
    }
}
