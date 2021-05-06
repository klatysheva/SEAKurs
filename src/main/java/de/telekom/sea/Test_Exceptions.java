package de.telekom.sea;

import java.util.ArrayList;

public class Test_Exceptions {
    public static void main(String[] args) {
        PersonsList personsList = new PersonsList(2);
        SeminarApp app = new SeminarApp();
        ArrayList<IEventListener> listenerList = new ArrayList();
        IEventListener eventListener = new PersonsMenu(personsList);
        IEventListener eventListener2 = new PersonsMenu(personsList);
        listenerList.add(eventListener);
        listenerList.add(eventListener2);

        app.run(personsList, listenerList);

    }

}
