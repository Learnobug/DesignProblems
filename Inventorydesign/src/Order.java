import java.util.ArrayList;
import java.util.List;

public class Order {
    private Product product;
    private int quantity;
    private double orderId;
    private Customer customer;
    private OrderState orderState;
    private List<Observer> observers = new ArrayList<>();


    public Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.orderState = OrderState.PENDING;
        this.orderId = (Math.random()*1000000);
        notifyObservers();
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
        notifyObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer o : observers) {
            o.update(this.orderState, this);
        }
    }


    public String getOrderId() {
        return String.format("%.0f", orderId);
    }
}
