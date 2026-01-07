public class ElevatorObserver {


    public void onElevatorStateChange(Elevator elevator, State state) {
        // Display the new state of the elevator
        System.out.println("Elevator " + elevator.getId() + " state changed to " + state);
    }


    public void onElevatorFloorChange(Elevator elevator, int floor) {
        // Display the elevator's movement to a new floor
        System.out.println("Elevator " + elevator.getId() + " moved to floor " + floor);
    }
}
