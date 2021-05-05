package task_Exceptions;

public class PersonsList extends BaseObject implements IList, IEventRegistration {
    private int LENGTH;
    private Object[] persons;
    private IEventListener eventListener = null;

    public PersonsList(int length) {
        this.LENGTH = length;
        this.persons = new Person[LENGTH];
    }

    public int getLENGTH() {
        return LENGTH;
    }

    public void subscribe(IEventListener eventListener){
        this.eventListener = eventListener;
    }

    public boolean add (Object obj) {
        System.out.println("############### Add person: #########################");
        //What must be checked first?
        if (isFull()) {
            System.out.println("List is full. All " + LENGTH + " places are taken.");
            return false;
        }
        if (obj == null) {
            System.out.println("It's null. Can't be added.");
            return false;
        }
        if (!(obj instanceof Person)) {
            System.out.println("It's not a person. Can't be added to this list.");
            return false;
        }
        Person person = (Person) obj;
        for (int i = 0; i < persons.length; i++) {
            if (persons[i] != null && persons[i].equals(person)) {
                System.out.println("Person is already in the list by #" + (i+1) + ". Can't be added.");
                return false;
            }
        }
        if (size() < persons.length ) {
            persons [size()] = person;
            //System.out.println(person.getSurname() + " " + person.getName()  + " added to the list under #" + size() + ".");
            Event personAdded = new Event("personAdded", person.getSurname() + " " + person.getName()  + " added to the list under #" + size() + ".");
            this.eventListener.receive(personAdded);
            if (isFull()) {
                Event listIsFull = new Event("listIsFull", "List is full.");
                this.eventListener.receive(listIsFull);
            }
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (size() == LENGTH) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public void clear () {
        System.out.println("############### Clear list: #########################");
        if (size() == 0) {
            System.out.println("List is already leer. Nothing to clear." );
            return;
        }
        persons = new Person[LENGTH];
        Event listIsEmpty = new Event("listIsEmpty","All elements are removed from the list.");
        this.eventListener.receive(listIsEmpty);
        isEmpty();
        //this.eventListener.receive(null);
    }

    public Person get(int i) {
        if ((i >= 0) && (i < persons.length)) {
            //System.out.println(persons[i]);
            return (Person) persons[i];
        }
        System.out.println("Wrong index. Index must be in the range from 0 to " + (persons.length));
        return null;
    }

    public boolean remove (Object obj) {
        System.out.println("############### Delete person: ######################");
        if (obj == null) {
            Event objectIsNull = new Event("objectIsNull", "It's null. Can't be deleted.");
            this.eventListener.receive(objectIsNull);
            return false;
        }
        if (!(obj instanceof Person)) {
            Event objectOfAnotherClass = new Event("objectOfAnotherClass", "Can't find this object in the list, it's not a person. It shouldn't be in the list. It's a person list!");
            this.eventListener.receive(objectOfAnotherClass);
            return false;
        }
        Person person = (Person) obj;
        for (int i = 0; i < persons.length; i++) {
            if (person.equals(persons[i])) {
                System.out.println("Deleting element #" + i +"...");
                for (int j = i; j<(persons.length-1); j++) {
                    persons [j] = persons [j+1];
                }
                persons [persons.length-1] = null;
                Event personDeleted = new Event("personDeleted", "Element # " + i + " was deleted from the list (" + person.getName() + " " + person.getSurname() + ").");
                this.eventListener.receive(personDeleted);
                return true;
            }
        }
        Event personNotFound = new Event("personNotFound","Can't be deleted. " + person.getName() + " " + person.getSurname() + "is not found in the list.");
        this.eventListener.receive(personNotFound);
        return false;
    }
    public boolean remove (String name, String surname) {
        System.out.println("############### Delete person: ######################");
        if ((name == null) || (surname == null)) {
            Event characteristicIsNull = new Event("characteristicIsNull", "Name or surname is null. Can't be deleted.");
            this.eventListener.receive(characteristicIsNull);
            return false;
        }
        for (int i = 0; i < size(); i++) {
            Person person = (Person) persons[i];
            if (person != null && name.equals(person.getName()) && surname.equals(person.getSurname())) {
                System.out.println("Deleting element #" + i +"...");
                for (int j = i; j<(persons.length-1); j++) {
                    persons [j] = persons [j+1];
                }
                persons [persons.length-1] = null;
                Event personDeleted = new Event("personDeleted", "Element #" + i + " was deleted from the list (" + person.getName() + " " + person.getSurname() + ").");
                this.eventListener.receive(personDeleted);
                return true;
            }
        }
        Event personNotFound = new Event("personNotFound", "Can't be deleted. " + name + " " + surname + "is not found in the list.");
        this.eventListener.receive(personNotFound);
        return false;
    }

    public boolean remove (int index) {
        System.out.println("############### Delete person: ######################");
        if ((index >= 0) && (index < persons.length)) {
            for (int i = index; i<(persons.length-1); i++) {
                persons [i] = persons [i+1];
            }
            persons [persons.length-1] = null;
            Event personDeleted = new Event("personDeleted", "Element #" + (index+1) + " was deleted from the list.");
            this.eventListener.receive(personDeleted);
            return true;
        }
        else {
            System.out.println("Index must be in the range from 0 to " + (size() - 1) + ".");
            return false;
        }

    }

    public int size() {
        int i =0;
        while (i < persons.length && persons[i]!=null ) i++;
        return i;
    }

    public int freePlaces() {
        int i = persons.length - size();
        return i;
    }

}