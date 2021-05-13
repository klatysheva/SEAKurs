package de.telekom.sea;

public class Person extends BaseObject {
    private String name;
    private String surname;
    private Salutation salutation;

    public Person(String surname, String name) {
        this.name = name;
        this.surname = surname;
    }

    public Person(Salutation salutation, String surname, String name) {
        this.salutation = salutation;
        this.surname = surname;
        this.name = name;
    }

    public Person(String salutation, String surname, String name) {
        this.salutation = Salutation.fromString(salutation);
        this.surname = surname;
        this.name = name;
    }

    public Person(Long id, String surname, String name) {
        super(id);
        this.name = name;
        this.surname = surname;
    }

    public Person(Long id, Salutation salutation, String surname, String name) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.salutation = salutation;
    }

    public Person(Long id, String salutation, String surname, String name) {
        super(id);
        this.salutation = Salutation.fromString(salutation);
        this.surname = surname;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSalutation(Salutation salutation) {
        this.salutation = salutation;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Salutation getSalutation() {
        return salutation;
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
        Person person = (Person) obj; // cast to Person
        return (person.getName().equals(this.name) && person.getSurname().equals(this.surname) && person.getSalutation().equals(this.salutation));
    }
}
