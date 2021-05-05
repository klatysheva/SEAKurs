package controlFlow;

public class ControlFlow {
    public static void main(String[] args) {
        multiplicationTable();
    }

    //Multiplikationstabelle
    static void multiplicationTable () {
        for (int i = 1; i<11; i++) {
            for (int j = 1; j<11; j ++) {
                if (i * j < 10) {
                    System.out.print("  ");
                }
                else if (i * j < 100) {
                    System.out.print(" ");
                }
                System.out.print(i * j + " ");
            }
            System.out.println();
        }
    }
}
