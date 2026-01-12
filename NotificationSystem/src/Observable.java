import java.util.ArrayList;
import java.util.List;


public abstract class Observable {
    List<Observer> observers = new ArrayList<>();

    void addObserver(Observer observer) {
        observers.add(observer);
    }

    void notifyObservers(Notification message) {
        for (Observer observer : observers) {
            observer.update(message.getContext());
        }
    }

}
