import java.util.List;

public class ElevatorController {
    List<Elevator> elevators = new java.util.ArrayList<>();
    List<Floor> floors = new java.util.ArrayList<>();
    SchedulingStrategy schedulingStrategy;

    public ElevatorController(int totalfloors, SchedulingStrategy strategy) {
        for(int i=0;i<totalfloors;i++){
            floors.add(new Floor(i));
        }
        this.schedulingStrategy = strategy;
    }

    Elevator getElevator(){
        // Implement logic to select an elevator based on scheduling strategy
        return elevators.get(0); // Placeholder: returns the first elevator
    }

    public void addElevator(Elevator elevator) {
        elevators.add(elevator);
    }

    public void step() {

            Elevator elevator = getElevator();
            if (!elevator.getRequests().isEmpty()) {

                int nextStop = schedulingStrategy.nextFloor(elevator);

                if (elevator.getCurrentfloor() != nextStop)
                    elevator.moveToNextfloor(nextStop);
            }

    }
}
