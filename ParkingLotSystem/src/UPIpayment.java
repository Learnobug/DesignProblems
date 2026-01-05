public class UPIpayment implements Payment{
    @Override
    public void pay(double amount, ParkingfeeStrategy ps, long hoursParked, VehicleType vehicleType, boolean isMember) {
        double finalAmount = ps.calculateFee((long)amount, vehicleType, isMember);
        System.out.println("Paid " + finalAmount + " using UPI payment method.");
    }
}
