import java.util.Queue;

public class FCFS implements SchedulingStrategy{
    @Override
    public int nextFloor(Elevator elevator) {
        int currentFloor = elevator.getCurrentfloor();
        Direction currentDirection = elevator.getDirection();
        Queue<Request> requests = elevator.getRequests();

        if (requests.isEmpty()){
            return currentFloor;
        }

        Request nextRequest = requests.peek();
        int nextFloor = nextRequest.getTargetFloor();

        if(nextFloor == currentFloor){
            return currentFloor;
        }

        if(currentFloor > nextFloor){
            elevator.setDirection(Direction.DOWN);
        }
        else{
            elevator.setDirection(Direction.UP);
        }
        return nextFloor;
    }
}
