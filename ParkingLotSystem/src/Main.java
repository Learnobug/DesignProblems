//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    Vehicle vehicle1 = new Car("KA-01-AB-1234" );
    Vehicle vehicle2 = new Bike("KA-01-XY-5678");

    User user1 = new User("Alice", vehicle1);
    User user2 = new User("Bob", vehicle2);

    ParkingfeeStrategy HourlyfeeStrategy = new HourlyfeeStrategy(3.0);
    ParkingfeeStrategy DailyfeeStrategy = new FixedfeeStrategy(20.0);

    ParkingSlot carSlot = new ParkingSlot(10, VehicleType.CAR);
    ParkingSlot bikeSlot = new ParkingSlot(5, VehicleType.Bike);

    ParkingSystem parkingSystem = new ParkingSystem();
    parkingSystem.addParkingSlot(carSlot);
    parkingSystem.addParkingSlot(bikeSlot);

    boolean isParked1 = parkingSystem.parkVehicle(user1, vehicle1, HourlyfeeStrategy);
    System.out.println("User 1 parked: " + isParked1);

    boolean isParked2 = parkingSystem.parkVehicle(user2, vehicle2, DailyfeeStrategy);
    System.out.println("User 2 parked: " + isParked2);

    double fee1 = parkingSystem.calculateParkingFee(user1, vehicle1, 4);
    System.out.println("User 1 parking fee for 4 hours: " + fee1);
    double fee2 = parkingSystem.calculateParkingFee(user2, vehicle2, 1);
    System.out.println("User 2 parking fee for 1 day: " + fee2);

    parkingSystem.unparkVehicle(user1, vehicle1);
    System.out.println("User 1 unparked.");
    parkingSystem.unparkVehicle(user2, vehicle2);
    System.out.println("User 2 unparked.");

}
