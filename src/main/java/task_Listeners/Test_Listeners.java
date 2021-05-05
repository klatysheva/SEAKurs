package task_Listeners;

public class Test_Listeners {
    public static void main(String[] args) {
        Person person1 = new Person("Antony", "Walker");
        Person person2 = new Person("Alex", "Anderson");

        PersonsList list1 = new PersonsList(2); //implements IList, IEventRegistration
        IEventListener eventListener = new PersonsMenu(list1); //implements IMenu, IEventListener
        list1.subscribe(eventListener); //IEventRegistration
        list1.add(person1); //IList

        PersonsMenu personsMenu = new PersonsMenu(list1);

        personsMenu.selectOption(); //IMenu

    }
}
