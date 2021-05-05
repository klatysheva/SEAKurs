package interfaces;

public class PersonsList implements IList {
    private Object[] persons = new Person[4];

    public boolean add (Object obj) {
        System.out.println("############### Add person: #########################");
        //What must be checked first?
        if (size() == persons.length) {
            System.out.println("List is full. All " + persons.length + " places are taken.");
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
            System.out.println(person.getSurname() + " " + person.getName()  + " added to the list under #" + size() + ".");
            System.out.println();
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
        persons = new Person [5];
        //alternative, not good, too risky:
//        for (int i = 0; i < persons.length; i++) {
//            persons[i] = null;
//        }
        System.out.println("All elements are removed from the list. List is leer now.");
        System.out.println();
    }

    public Person get(int i) {
        if ((i > 0) && (i < persons.length)) {
            System.out.println(persons[i]);
            return (Person) persons[i];
        }
        System.out.println("Wrong index. Index must be in the range from 0 to " + (persons.length));
        return null;
    }

    public boolean remove (Object obj) {
        System.out.println("############### Delete person: ######################");
        if (obj == null) {
            System.out.println("It's null. Can't be deleted.");
            return false;
        }
        if (!(obj instanceof Person)) {
            System.out.println("Can't find this object in the list, it's not a person. It shouldn't be in the list. It's a person list!");
            return false;
        }
        Person person = (Person) obj;
//      TO DO: check
//        int i = 0;
//        while ((i < persons.length) && !(persons[i].equals(person))) i++;
        for (int i = 0; i < persons.length; i++) {
            if (person.equals(persons[i])) {
                System.out.println("Deleting element #" + i +"...");
                for (int j = i; j<(persons.length-1); j++) {
                    persons [j] = persons [j+1];
                }
                persons [persons.length-1] = null;
                System.out.println("Element #" + i + " was deleted from the list (" + person.getName() + " " + person.getSurname() + ").");
                return true;
            }
        }
        System.out.println("Can't be deleted. " + person.getName() + " " + person.getSurname() + "is not found in the list.");
        return false;
    }

    public boolean remove (int index) {
        System.out.println("############### Delete person: ######################");
        if ((index > 0) && (index < persons.length)) {
            for (int i = index; i<(persons.length-1); i++) {
                persons [i] = persons [i+1];
            }
            System.out.println("Element #" + (index+1) + " was deleted from the list.");
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

    public  void showFullList() {
        System.out.println("############### Persons List(+nulls and references) #");
        for (int i = 0; i < persons.length; i++){
            Person person = (Person) persons[i];
            System.out.print((i+1) + ". " + person);
            if (persons[i] != null) {
                System.out.println(": " + person.getSurname() + " " + person.getName());
            }
            else {
                System.out.println();
            }
        }
        System.out.println("Persons count: " + size() + ".");
        System.out.println();
    }
    public  void showList () {
        System.out.println("############### Persons List  #######################");
        for (int i = 0; i < persons.length; i++){
            if (persons[i] != null) {
                Person person = (Person) persons[i];
                System.out.println((i+1) + ". " + person.getSurname() + " " + person.getName());
            }
        }
        System.out.println("Persons count: " + size() + ".");
        System.out.println();
    }

    public void showSize() {
        System.out.println("There are " + size() + " element(s) in the list.");
        System.out.println();
    }

}