import java.util.ArrayList;
import java.util.List;

// notifaction -> ne
public class NotificationService {
    List<Notification> notifications = new ArrayList<>();
    Observable notificationObservable;
    private NotificationService() {};
    public static NotificationService instance= null;

    public static NotificationService getInstance(){
        if(instance == null){
            instance = new NotificationService();
        }
        return instance;
    }

    public void setnotificationObservable(Observable notificationObservable){
        this.notificationObservable = notificationObservable;
    }

    public void addObserver(Observer observer){
        notificationObservable.addObserver(observer);
    }

    public void addNotification(Notification notification) {
        notifications.add(notification);
        notificationObservable.notifyObservers(notification);
    }


}
