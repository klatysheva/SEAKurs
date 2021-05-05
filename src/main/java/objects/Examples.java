package objects;

public class Examples {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.name = "Paul";
        //person1.surname = "Paulsen";
        Person person2 = new Person("Addington");
        Person person3 = new Person("Sam", "Smith");
        showFullName(person1);
        showFullName(person2);
        showFullName(person3);

    }

    private static void showFullName(Person person) {
        System.out.print((person.name == null)? "- " : person.name + " ");
        System.out.println((person.surname == null)? "-" : person.surname);
    }

    static class Person {
        public String name;
        public String surname;

        public Person() {}

        public Person(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public Person(String surname) {
            this.surname = surname;
        }
    }




}
