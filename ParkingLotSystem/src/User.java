public class User {
    String name;
    double userId;
    Vehicle vehicle;

    public User(String name, Vehicle vehicle) {
        this.name = name;
        this.vehicle = vehicle;
        this.userId = (Math.random()*100);
    }

    public VehicleType getVehicleType() {
        return vehicle.getVehicleType();
    }
}
