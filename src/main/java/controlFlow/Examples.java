package controlFlow;

public class Examples {

    public static void main(String[] args) {
        int age = 21; //declares variable, assigns an initial value

        if (age > 17) { // decision to execute code
            System.out.println("I am of age"); // conditionally executed code
        }
        else { //optional
            System.out.println("I am a kid"); // conditionally executed code
        }

        switch (age) {
            case 17:
                System.out.println("I am of age 17");
            case 18:
                System.out.println("I am of age 18");
            case 19:
                System.out.println("I am of age 19");
        }

        //Endless loop:
        var i = 1; // simple assignment
        while(i<6) {// decision to execute code
            System.out.println("I am " + i + " years old"); // conditionally executed code
        }
    }

}
