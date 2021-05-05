package de.telekom.sea;

public class Test_Exceptions {
    public static void main(String[] args) {
        Person person1 = new Person("Antony", "Walker");
        Person person2 = new Person("Alex", "Anderson");

        PersonsList list1 = new PersonsList(2); //implements IList, IEventRegistration
        System.out.println(list1.get(0));
        System.out.println(list1.get(-1));
        System.out.println(list1.get(3));

    }
}
