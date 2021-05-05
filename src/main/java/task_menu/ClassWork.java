package task_menu;

import java.util.Scanner;

public class ClassWork {
    public static void main(String[] args) {
        var result = "";
        do {
            System.out.println("Enter your number: ");
            Scanner scanner = new Scanner(System.in);
            result = scanner.nextLine();
            switch (result) {
                case "1":
                    System.out.println("It's 1");
                    break;
                case "2":
                    System.out.println("It's 2");
                    break;
                case "3":
                    System.out.println("It's 3");
                    break;
                default:
                    System.out.println("It's something else");
            }
        }
        while (!result.equals("4"));
    }
}
