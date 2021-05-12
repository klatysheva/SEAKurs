package de.telekom.sea;

import java.io.IOException;
import java.nio.file.WatchEvent;
import java.util.ArrayList;

public class Test_Exceptions {
    public static void main(String[] args) throws IOException {
        PersonsList personsList = new PersonsList(5);
        SeminarApp app = new SeminarApp();
        ArrayList<IEventListener> listenerList = new ArrayList();
        IEventListener eventListener = new PersonsMenu(personsList);
        IEventListener eventListener2 = new PersonsMenu(personsList);
        listenerList.add(eventListener);
        listenerList.add(eventListener2);

        //app.run(personsList, listenerList);
        app.run(personsList, eventListener);

    }

}
