public class EmailObserver implements Observer{
    String email;

    public EmailObserver(String email) {
        this.email = email;
    }
    @Override
    public void update(OrderState status, Order order) {
        System.out.println("Email Notification: Your order " + order.getOrderId() + " is now " + status);
    }
}
