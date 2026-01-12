//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    NotificationService notificationService = NotificationService.getInstance();

    //Notification
    Notification notification1 = new FrameDecorator(new SimpleNotification("Hello, this is your first notification!"));

    //Observable
    Observable observable = new NotificationObservable();

    //Observer
    NotificationStrategy sms =  new SMSstrategy();
    NotificationEngine notificationEngine = new NotificationEngine();
    notificationEngine.addStrategy(sms);

    //add observer to observable
    observable.addObserver(notificationEngine);

    //subscribe observable to notification service
    notificationService.setnotificationObservable(observable);

    //push notification
    notificationService.addNotification(notification1);



}
