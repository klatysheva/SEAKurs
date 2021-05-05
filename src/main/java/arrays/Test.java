package arrays;

import arrays.task_persons.Person;

public class Test {
    public static void main(String[] args) {
        Character array = new Character();
        System.out.println(array.values);
        array.set(0, 'a');
        array.set(1, 'B');
        array.set(2, 'c');
        array.set(3, 'D');
        array.set(4, 'e');
        array.set(5, 'F');
        array.set(6, 'g');
        array.set(7, 'H');
        System.out.println(array.values);
        for (int i =0; i < 8; i++) {
            System.out.println(array.get(i));
        }
        int [] intArray = new int[16]; //size must be set!
        boolean [] booleanArray = new boolean[5];

        Person [] personArray = new Person[10]; // create massive
        personArray[2] = new Person("sdfa", "adfa", 23 );
        System.out.println(personArray[2].getSurname());

    }
}
