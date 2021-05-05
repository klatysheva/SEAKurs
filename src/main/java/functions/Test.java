package functions;

import static functions.MathFunctionsBase.*;
import static functions.MyFunctions.*;

public class Test {
    public static void main(String[] args) {
        add (3, 4, 6);
        add (3, 4);
        divide (3, 4);
        System.out.println(isEven (6));
        System.out.println(isEven (5));
        System.out.println(isEven (0));
        System.out.println(hyperbola (4));
    }
}
