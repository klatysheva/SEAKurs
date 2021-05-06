package de.telekom.sea;

import java.util.ArrayList;

public class SeminarApp extends BaseObject {

    public void run (PersonsList list, ArrayList<IEventListener> listenerList) {
        //for test only:
        Person person1 = new Person("Antony", "Walker");
        list.add(person1);

        try (PersonsMenu menu = new PersonsMenu(list)) {
            for (IEventListener e : listenerList) {
                list.subscribe(e);
            }
            menu.selectOption();
            list.unsubscribeAll();
            //for test only:
            menu.selectOption();
        }

    }

    public Object getRootApp () { //if add 'static' -> doesn't work; class doesn't have instances, then uncomment #4; return thisSeminarApp
        return this;
    }
}

