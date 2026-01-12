public class SimpleNotification implements Notification{
    private String context;

    public SimpleNotification(String context) {
        this.context = context;
    }

    @Override
    public String getContext() {
        return context;
    }
}
