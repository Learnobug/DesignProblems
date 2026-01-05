public class ParkingLot {
    int uniqueId;
    VehicleType vehicleType;
    boolean isOccupied;
    User user;
    ParkingfeeStrategy parkingfeeStrategy;

    ParkingLot(int uniqueId, VehicleType vehicleType, ParkingfeeStrategy parkingfeeStrategy) {
        this.uniqueId = uniqueId;
        this.vehicleType = vehicleType;
        this.isOccupied = false;
        this.parkingfeeStrategy = parkingfeeStrategy;
    }

    public boolean isOccupied() {
        return isOccupied;
    }
}
