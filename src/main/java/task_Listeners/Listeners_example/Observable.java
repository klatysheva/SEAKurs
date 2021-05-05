package task_Listeners.Listeners_example;

import java.util.LinkedList;
import java.util.List;

public class Observable {
    private List<Observer> observers;

    public Observable() {
        observers = new LinkedList<>();
    }

    public void addObsever(Observer observer) {
        observers.add(observer);
    }

    private  void notifyObservers(String whatHappened) {
        for (Observer observer : observers) {
            observer.onSomethingHappened(whatHappened);
        }
    }

    public void doSomeStuff() {
        // ...
        // Do some business logic here.
        // ...

        // Now we want to notify all the listeners about something.
        notifyObservers("We found it!");

        // ...
        // Do some business logic here
        // ...
    }
}