public class FixedfeeStrategy extends ParkingfeeStrategy{
    private final double fixedFee;

    public FixedfeeStrategy(double fixedFee) {
        this.fixedFee = fixedFee;
    }

    @Override
    public double calculateFee(long hoursParked, VehicleType vehicleType, boolean isMember) {
        return fixedFee;
    }
}
