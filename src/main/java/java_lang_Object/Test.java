package java_lang_Object;

public class Test {
    public static void main(String[] args) {
        Person person1 = new Person("Adam", "Smith", 32);
        person1.getSurname();
        person1.setSurname("Johnson");
        person1.getSurname();
        Person person2 = new Person("John", "Williams ", 23);
        Person person3 = new Person("John", "Williams ", 23);
        Person person4 = person3;
        Person person5 = new Person("John", "Williams ", 23);
        Animal cat1 = new Animal ("F. catus");

        showIfObjectsAreEqual(person1, person2);
        showIfObjectsAreTheSame(person1, person2);
        showIfObjectsAreEqual(person2, person3);
        showIfObjectsAreTheSame(person2, person3);
        showIfObjectsAreEqual(person3, person4);
        showIfObjectsAreTheSame(person3, person4);
        showIfObjectsAreTheSame(person3, cat1);

        //reflexive: for any object instance x, the result of x.equals(x) should be true
        System.out.println(person1.equals(person1));
        System.out.println(person2.equals(person2));
        System.out.println(person3.equals(person3));
        System.out.println(person4.equals(person4));
        //symetric: for any two object instances x and y, the result of x.equals(y) and y.equals(x) should be the same
        System.out.println(person2.equals(person3));
        System.out.println(person3.equals(person2));
        System.out.println(person2.equals(person1));
        System.out.println(person1.equals(person2));
        //transitive: for any three object intances x, y and z, if x.equals(y) is true and y.equals(z) is true, then x.equals(z) is also true
        System.out.println(person2.equals(person3));
        System.out.println(person2.equals(person5));
        System.out.println(person3.equals(person5));
        //not equal to null:
        System.out.println(person3.equals(null));
        System.out.println(person1.getClass().getName());
        System.out.println(person1.getClass().getCanonicalName());
    }
    private static void showIfObjectsAreTheSame(Person person1, Object person2) {
        if (person1.equals(person2)) {
            System.out.println("Person (" + person1 + ") and Object (" + person2 + ") are the same");
        }
        else {
            System.out.println("Person (" + person1 + ") and Object (" + person2 + ") are not the same");
        }
    }

    private static void showIfObjectsAreEqual(Person person1, Person person2) {
        if(person1 == person2) {
            System.out.println("Person (" + person1 + ") and Object (" + person2 + ") are equal");
        }
        else {
            System.out.println("Person (" + person1 + ") and Object (" + person2 + ") are not equal");
        }
    }
}
