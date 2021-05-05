package task_BaseObject;

public class Test_BaseObject {
    public static void main(String[] args) {
        PersonsMenu menu = new PersonsMenu();
        IList list = new PersonsList();

        //Person person = new Person("Ann", "Walker");
        Person person1 = new Person("Alex", "Anderson");
        Person person2 = new Person("Anthony", "Clark");

        Person person3 = new Person();
        person3.setId(person1.getId());
        Person person4 = person1;

        System.out.println("Person1 getId: " + person1.getId());
        System.out.println("Person3 getId: " + person3.getId());
        System.out.println("Person4 getId: " + person4.getId());

        System.out.println("Person1 toString: " + person1.toString());
        System.out.println("Person3 toString: " + person3.toString());
        System.out.println("Person4 toString: " + person4.toString());
        System.out.println("Person1 == null (ER: false): " + person1.equals(null));
        System.out.println("Person1 == person1 (ER: true): " + person1.equals(person1));
        System.out.println("Person1 == person4 (ER: true): " + person1.equals(person4));
        System.out.println("Person1 == person3 (ER: true): " + person1.equals(person3)); //returns false if Person.equals in not commented, since name/surname are different
        System.out.println("Person1 == person2 (ER: false): " + person1.equals(person2));
    }
}
