import java.util.Date;

public class Reservation {
    Car car;
    Customer customer;
    PaymentStrategy paymentStrategy;
    Date startDate;
    Date endDate;
    Reservation(Car car,Customer customer,PaymentStrategy paymentStrategy,Date startDate,Date endDate){
        this.car = car;
        this.customer = customer;
        this.startDate = startDate;
        this.paymentStrategy = paymentStrategy;
        this.endDate =  endDate;
        this.car.setState(ReservationState.BOOKED);
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void processPayment(){
        double amount = calculateAmount();
        paymentStrategy.pay((int)amount);
    }

    private double calculateAmount(){
        long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
        long diffInDays = diffInMillies / (1000 * 60 * 60 * 24);
        return diffInDays * car.getPrice();
    }

}
