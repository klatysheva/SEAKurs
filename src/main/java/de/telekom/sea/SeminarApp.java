package de.telekom.sea;

import java.util.ArrayList;

public class SeminarApp extends BaseObject {

    //public void run (PersonsList list, ArrayList<IEventListener> listenerList) {
    public void run (PersonsList list, IEventListener eventListener) {
        //for test only:
        Person person1 = new Person("Antony", "Smith");
        Person person2 = new Person("Walker", "Antony");
        Person person3 = new Person("Sam", "Smith");
        Person person4 = new Person("John", "Adams");
        list.add(person3);
        list.add(person4);
        list.add(person1);


        try (PersonsMenu menu = new PersonsMenu(list)) {
            menu.showList();
            list.subscribe(eventListener);
            list.add(person2);
//            for (IEventListener e : listenerList) {
//                list.subscribe(e);
//            }
            menu.selectOption();
            //list.unsubscribeAll();
            //for test only (to check unsubscribe):
            //menu.selectOption();
        }
    }

    public Object getRootApp () { //if add 'static' -> doesn't work; class doesn't have instances, then uncomment #4; return thisSeminarApp
        return this;
    }
}

