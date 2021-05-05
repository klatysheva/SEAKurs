package task_Listeners;

public class SeminarApp extends Child {
    //private static SeminarApp thisSeminarApp;

    public void run (String[] args, String personName, String personSurname) {
        Person person = new Person(personName, personSurname);
        System.out.println("Hello, " + person.getName() + "!");
        //test(person);
    }

    //just to check references
    private void test(Person person) {
        System.out.println("##### tests #####");
        person.setParent(this);
        System.out.println("SeminarApp: " + this);
        System.out.println("getParent: " + getParent());
        System.out.println("Person: " + person);
        System.out.println("Parent (for SeminarApp): " + this.getParent());
        System.out.println("Parent (for person): " + person.getParent());
        System.out.println("This: " + this);
        this.setParent(new Person ());
        System.out.println("getParent (this): " + this.getParent());
        System.out.println("getParent (person): " + person.getParent());
    }

    public Object getRootApp () { //if add 'static' -> doesn't work; class doesn't have instances, then uncomment #4; return thisSeminarApp
        return this;
    }
}

