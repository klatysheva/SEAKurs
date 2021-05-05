package java_lang_Object;


public class Person /* extends Object */ {
    private String name;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    private String surname;
    private int age;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int hashCode () {
        return (int) (Math.pow(name.length(), 2) + Math.pow(surname.length(), 3) +Math.pow(age, 4));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) // null check
        {
            return false;
        }
        if (this == obj) // self check
        {
            return true;
        }
        if (getClass() != obj.getClass()) {// type check
            System.out.println("Objects of different classes");
            return false;
        }
        if (this.hashCode() != obj.hashCode()) // hash code check
        {
            return false;
        }
        // type check and cast
        Person person = (Person) obj; // cast to Person
        return Objects.equals(name, person.name)
                && Objects.equals(surname, person.surname)
                && Objects.equals(age, person.age);
    }
}
