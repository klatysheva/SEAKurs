package task_Exceptions;

public class Person extends BaseObject {
    private String name;
    private String surname;

    public Person() {
    }

    public Person(String name, String surname) {
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
//        if (obj == null) { return false; } // null check, moved to the BaseObject
//        if (this == obj) { return true;} // self check, moved to the BaseObject
        if (!super.equals(obj)) { // equals class from BaseObject since this class extends BaseObject
            return false;
        }

        if (!(obj instanceof Person)) {// type check
            //System.out.println("Objects of different classes");
            return false;
        }
        // type check and cast
        Person person = (Person) obj; // cast to Person
        return (person.getName().equals(this.name) && person.getSurname().equals(this.surname));
    }
}
