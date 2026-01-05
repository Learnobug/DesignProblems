public interface Payment {
    void pay(double amount,ParkingfeeStrategy ps, long hoursParked, VehicleType vehicleType, boolean isMember);
}
