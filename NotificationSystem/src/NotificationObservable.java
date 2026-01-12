public class NotificationObservable extends Observable{
    protected Notification notification;

    public void notifyObservers() {
        super.notifyObservers(notification);
    }

}
