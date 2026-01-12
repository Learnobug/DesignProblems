public class SMSstrategy implements NotificationStrategy{
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS notification with message: " + message);
    }
}
