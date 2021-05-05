package Quests.Quest856;

import java.util.Arrays;

public class ArraysAndItteration {
    public static void main(String[] args) {
        String weapon1 = "whip";
        String weapon2 = "gun";
        String weapon3 = "saber";

        String[] weapons = new String[] {"whip", "gun", "saber"};
        System.out.println(weapons.length); // displays 3
        String[] weapons2 = {"whip", "gun", "saber"};
        int[] evens = {0, 2, 4, 4, 6, 8};
        double[] values = new double[10];

        System.out.println(weapons[0]); // displays : whip
        System.out.println(weapons[1]); // displays : gun
        System.out.println(weapons[2]); // displays : saber

        weapons[2] = "sword";
        System.out.println(Arrays.toString(weapons)); // displays [whip, gun, sword]

        String[] weaponsIndiana = {"whip", "gun", "saber"};
        String[] weaponsHelen = {"knife", "shield"};
        String[] weaponsRavenwood = { "belt", "dagger", "gun", "shield"};

        String[][] weapons3;
        weapons3 = new String[][] {
                weaponsIndiana,
                weaponsHelen,
                weaponsRavenwood
        };

        System.out.println(Arrays.toString(weapons3[0])); //[whip, gun, saber]
        System.out.println(Arrays.toString(weapons3[1])); //[knife, shield]
        System.out.println(Arrays.toString(weapons3[2])); //[belt, dagger, gun, shield]

        String[][] weapons4 = new String[][] {
                {"whip","gun,","saber"},
                {"knife", "shield"},
                {"belt", "dagger", "gun", "shield"}
        };
        System.out.println(weapons4.length); // displays 3
        System.out.println(weapons4[1].length); // displays 2
        System.out.println(weapons4[2].length); // displays 4

        int[] array = {2, 4, 1, 0, 0, 8, 5};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array)); // displays [0, 0, 1, 2, 4, 5, 8]

        String[] weapons5 = {"whip", "gun", "saber"};
        Arrays.sort(weapons5);
        System.out.println(Arrays.toString(weapons5)); // displays [gun, saber, whip]

        // Concrete example of a loop iterating through 0 to 9 which increments by 1
        for (int i = 0; i < 10; i++) {
            // Do something
        }

        // But we could have written it like this:
        for (int counter = 0; counter < 10; counter++) {
            // Do something
        }

        // And if we wanted to go backwards from 9 to 0 instead:
        for (int i = 9; i >= 0; i--) {
            // Do something
        }

        String[] weapons6 = {"whip", "gun", "saber"}; // the length is 3

        for (int i = 0; i < weapons6.length; i++) {
            System.out.println(weapons6[i]); // displays the weapon in position i
        }

        // Example of a 'good' while loop
        int i = 0;
        while (i < 10) {
            i++;
            // Do something
        }

        // Example of an infinite loop (DO NOT DO!!!!!)
        String firstname = "Henry";
        while (!firstname.equals("Indy")) {
            firstname = "Indiana";
            /// Do something....
        }

        String[] weapons7 = {"whip", "gun", "saber"};

        for (String weapon : weapons7) {
            System.out.println(weapon); // displays the weapon
        }



    }
}
