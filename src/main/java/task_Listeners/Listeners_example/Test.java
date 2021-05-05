package task_Listeners.Listeners_example;

public class Test {
    public static void main(String[] args) {

        // Create the observable.
        Observable myObservable = new Observable();

        // Create the observers (aka listeners).
        Observer myObserverA = new MyObserver();
        Observer myObserverB = new MyObserver();

        // Register the observers (aka listeners).
        myObservable.addObsever(myObserverA);
        myObservable.addObsever(myObserverB);

        myObservable.doSomeStuff();

    }
}
