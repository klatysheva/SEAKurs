package de.telekom.sea.classwork.exceptions;

import de.telekom.sea.Person;
import de.telekom.sea.PersonsList;
import de.telekom.sea.WrongIndexException;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws SomeException, WrongIndexException {
        Person person1 = new Person("Mr", "Antony", "Walker");
        Person person2 = new Person("Mister", "Alex", "Anderson");

        PersonsList list1 = new PersonsList(2); //implements IList, IEventRegistration

        list1.add(person1);

        UseObject useObject = new UseObject();
        useObject.test();
        try {
            function();
        } catch (RuntimeException rte) {
            throw new RuntimeException("My RuntimeException");
        }

        try {
            list1.get(-1);
        } finally {
            //e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in); //Exception
        try {
            anyLoop(scanner);
        } finally {
            scanner.close();
        }
    }

//    void anyMethod throws OutOfMemoryError {
//    }
    static void open () {
        System.out.println("open");
    }
    static void doLoop () {
        throw new RuntimeException();
    }
    static void close () {
        System.out.println("close");
    }

    static void function() {
        try {
            open();
            doLoop(); //<-Exception
        } finally { //this will be run anyway; NOT CATCH! exception will be transferred up
            close();
        }
    }

    static void anyLoop (Scanner scanner) {
        scanner.nextLine();
    }
}
