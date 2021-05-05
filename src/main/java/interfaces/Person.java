package interfaces;

public class Person /* extends Object */ {
    private String name;
    private String surname;

    public Person() {
    }
    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
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
            //System.out.println("Objects of different classes");
            return false;
        }

        // type check and cast
        Person person = (Person) obj; // cast to Person
        return Objects.equals(name, person.name)&&
                Objects.equals(surname, person.surname);
    }
}