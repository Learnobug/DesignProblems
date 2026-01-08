public class UPIPayment implements PaymentStrategy{
    @Override
    public void pay(int amount){
        //process Payement
        System.out.println("Pay via UPI: " + amount);
    }
}
