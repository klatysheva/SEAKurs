package arrays;

public class MyArray {
    public static void main(String[] args) {
        System.out.println(args.length);
        // cd ..../src
        // java MyArray.java bla -> 1
        // java MyArray.java bla bla -> 2
        // java MyArray.java bla bla bla -> 3
        System.out.println(args[0]);
        // java MyArray.java bla -> bla
    }
}
