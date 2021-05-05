package operators;

import java.util.Scanner;

public class Operators {
    public static void main(String[] args) {
        //Scanner input = new Scanner(System.in);
        //int a = input.nextInt();
        //int b = input.nextInt();
        int a = 3, b =4;
        System.out.println("a=" + a + ", b=" + b +".");
        System.out.println("a+b=" + (a+b));
        System.out.println("a>b:" + (a>b));
        System.out.println("a<: "+ (a<b));
        System.out.println("++a=" + (++a));
        System.out.println("--b=" + (--b));
        System.out.println((a<=b)? "a<=b" : "a>b");
        System.out.println("a%b: " + a%b);
    }
}
