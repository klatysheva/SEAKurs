package de.telekom.sea;

import java.util.ArrayList;
import java.util.Locale;

public class PersonsList extends BaseObject implements IList, IEventRegistration {
    private int LENGTH;
    private Person[] persons;
    private ArrayList<IEventListener> listenerList = new ArrayList();

    public PersonsList(int length) {
        this.LENGTH = length;
        this.persons = new Person[LENGTH];
    }

    public void subscribe(IEventListener eventListener){
        listenerList.add(eventListener);
        //this.eventListener = eventListener;
    }

    public void unsubscribeAll(){
        listenerList.clear();
    }
    public int getLENGTH() {return LENGTH;}

    public boolean add (Object obj) {
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
            sendEvent("personAdded", person.getSurname() + " " + person.getName()  + " added to the list under #" + size() + ".");
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

    public IList searchByText(String text, String searchOption, boolean isCaseSensitive) {
        IList sublist = new PersonsList(size());

        System.out.println("Search result: ");
        for (int i = 0; i < size(); i++) {
            String name;
            String surname;
            if (isCaseSensitive == true) {
                name = persons[i].getName();
                surname = persons[i].getSurname();
            }
            else {
                text = text.toLowerCase(Locale.ROOT);
                name = persons[i].getName().toLowerCase(Locale.ROOT);
                surname = persons[i].getSurname().toLowerCase(Locale.ROOT);
            }
            if (searchOption.equals("contains") && (name.contains(text) || surname.contains(text)) ) {
                sublist.add(persons[i]);
            }
            if (searchOption.equals("startWith") && (name.startsWith(text) || surname.startsWith(text)) ) {
                sublist.add(persons[i]);
            }
        }
        if (sublist.size() == 0) {
            System.out.println("Search returned no results.");
        }
        else {
            for (int i = 0; i < sublist.size(); i++) {
                System.out.println((i+1) + ". " + persons[i].getName() + " " + persons[i].getSurname() + ".");
            }

        }
        return sublist;
    }

    public void clear () {
        System.out.println("############### Clear list #########################");
        if (size() == 0) {
            System.out.println("List is already leer. Nothing to clear." );
            return;
        }
        persons = new Person[LENGTH];
        sendEvent("listIsEmpty","All elements are removed from the list.");
        isEmpty();
        //this.eventListener.receive(null);
    }

    public Person get(int i) {
        if ((i >= 0) && (i < persons.length)) {
            return (Person) persons[i];
        }
        else {
            throw new WrongIndexException(i, persons.length);
            //throw new RuntimeException("Wrong index. Index must be in the range from 0 to " + (persons.length) + ".");
        }
    }

    public boolean remove (Object obj) {
        System.out.println("############### Delete person ######################");
        if (obj == null) {
            sendEvent("objectIsNull", "It's null. Can't be deleted.");
            return false;
        }
        if (!(obj instanceof Person)) {
            sendEvent("objectOfAnotherClass", "Can't find this object in the list, it's not a person. It shouldn't be in the list. It's a person list!");
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
                sendEvent("personDeleted", "Element # " + i + " was deleted from the list (" + person.getName() + " " + person.getSurname() + ").");
                return true;
            }
        }
        sendEvent("personNotFound","Can't be deleted. " + person.getName() + " " + person.getSurname() + "is not found in the list.");

        return false;
    }

    private void sendEvent(String eventName, String eventDescription) {
        Event event = new Event(eventName, eventDescription);
        for (IEventListener e : listenerList) {
            e.receive(event);
        }
    }

    public boolean remove (String name, String surname) {
        System.out.println("############### Delete person ######################");
        if ((name == null) || (surname == null)) {
            sendEvent("characteristicIsNull", "Name or surname is null. Can't be deleted.");
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
                sendEvent("personDeleted", "Element #" + i + " was deleted from the list (" + person.getName() + " " + person.getSurname() + ").");
                return true;
            }
        }
        sendEvent("personNotFound", "Can't be deleted. " + name + " " + surname + "is not found in the list.");
        return false;
    }

    public boolean remove (int index) {
        System.out.println("############### Delete person ######################");
        if ((index >= 0) && (index < persons.length)) {
            for (int i = index; i<(persons.length-1); i++) {
                persons [i] = persons [i+1];
            }
            persons [persons.length-1] = null;
            sendEvent("personDeleted", "Element #" + (index+1) + " was deleted from the list.");
            return true;
        }
//        else {
//            throw new RuntimeException("Wrong index. Index must be in the range from 0 to " + (size() - 1) + ".");
//        }
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