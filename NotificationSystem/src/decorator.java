public abstract class decorator implements Notification{
    protected Notification notification;

    public decorator(Notification notification) {
        this.notification = notification;
    }

    public String getContext(){
        return notification.getContext();
    }
}
