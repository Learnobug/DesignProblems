public abstract class Vehicle {
    String licensePlate;
    VehicleType vehicleType;

    public Vehicle(String licensePlate,VehicleType vt) {
        this.licensePlate = licensePlate;
        this.vehicleType = vt;

    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
