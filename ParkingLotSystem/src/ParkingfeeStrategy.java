public abstract class ParkingfeeStrategy {
    public abstract double calculateFee(long parkingDurationInHours, VehicleType vehicleType, boolean isMember);
}
