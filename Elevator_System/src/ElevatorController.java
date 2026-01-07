import java.util.List;

public class ElevatorController {
    List<Elevator> elevators = new java.util.ArrayList<>();
    List<Floor> floors = new java.util.ArrayList<>();

    public ElevatorController(int totalfloors) {
        for(int i=0;i<totalfloors;i++){
            floors.add(new Floor(i));
        }
    }

    Elevator getElevator(){
        // Implement logic to select an elevator based on scheduling strategy
        return elevators.get(0); // Placeholder: returns the first elevator
    }

    public void addElevator(Elevator elevator) {
        elevators.add(elevator);
    }

}
