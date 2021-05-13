package de.telekom.sea;

import java.io.IOException;
import java.util.ArrayList;

import static de.telekom.sea.Salutation.*;

public class SeminarApp extends BaseObject {

    //public void run (PersonsList list, ArrayList<IEventListener> listenerList) {
    public void run (PersonsList list, IEventListener eventListener) throws IOException {
        //for test only:
        Person person1 = new Person(MR, "Smith", "Antony");
        Person person2 = new Person(MR,"Walker", "Antony");
        Person person3 = new Person(MR,"Antony", "Sam");
        Person person4 = new Person(MISS,"Adams", "Susi");
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

