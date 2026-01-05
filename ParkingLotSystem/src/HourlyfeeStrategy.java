public class HourlyfeeStrategy extends ParkingfeeStrategy {
    private final double hourlyRate;

    public HourlyfeeStrategy(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }


    public double calculateFee(long hoursParked, VehicleType vehicleType, boolean isMember) {
        return hourlyRate * hoursParked;
    }
}
