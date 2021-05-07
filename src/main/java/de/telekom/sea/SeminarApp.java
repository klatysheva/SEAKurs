package de.telekom.sea;

import java.util.ArrayList;

public class SeminarApp extends BaseObject {

    public void run (PersonsList list, ArrayList<IEventListener> listenerList) {
        //for test only:
        Person person1 = new Person("Antony", "Smith");
        Person person2 = new Person("Walker", "Antony");
        Person person3 = new Person("Sam", "Smith");
        Person person4 = new Person("John", "Adams");
        list.add(person3);
        list.add(person4);
        list.add(person1);
        list.add(person2);

        try (PersonsMenu menu = new PersonsMenu(list)) {
            menu.showList();
            for (IEventListener e : listenerList) {
                list.subscribe(e);
            }
            menu.selectOption();
            list.unsubscribeAll();
            //for test only (to check unsubscribe):
            //menu.selectOption();
        }
    }

    public Object getRootApp () { //if add 'static' -> doesn't work; class doesn't have instances, then uncomment #4; return thisSeminarApp
        return this;
    }
}

