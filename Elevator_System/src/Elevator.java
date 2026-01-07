import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Elevator {
    int uniqid;
    int currentfloor;

    Direction direction;
    State state;
    int capacity;
    Queue<Request> requests = new java.util.LinkedList<>();
    List<ElevatorObserver> observers = new java.util.ArrayList<>();
    SchedulingStrategy schedulingStrategy;

    Elevator( int capacity, SchedulingStrategy schedulingStrategy) {
        this.uniqid = Math.toIntExact(Math.round(Math.random() * 100));
        this.currentfloor = 0;

        this.direction = Direction.IDLE;
        this.state = State.IDLE;
        this.capacity = capacity;
        this.schedulingStrategy = schedulingStrategy;
    }

    public void addObserver(ElevatorObserver observer) {
        observers.add(observer);
    }

    public int getCurrentfloor() {
        return currentfloor;
    }

    public Direction getDirection() {
        return direction;
    }
    public Queue<Request> getRequests() {
        return requests;
    }

    public int getId() {
        return uniqid;
    }


    public State getState() {
        return state;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void addRequest(Request request) {
        if(requests.contains(request)){
            return;
        }

        if(this.state == State.IDLE){
            if(request.getTargetFloor() > this.currentfloor){
                this.direction = Direction.UP;
            }
            else if(request.getTargetFloor() < this.currentfloor){
                this.direction = Direction.DOWN;
            }
            this.state = State.MOVING;
            notifyforstatechange();
        }
        requests.add(request);
    }

    public int getnextFloor() {
        return schedulingStrategy.nextFloor(this);
    }



    public void notifyforstatechange() {
        for(ElevatorObserver observer : observers){
            observer.onElevatorStateChange(this, this.state);
        }
    }

    public  void notifyforfloorchange() {
        for(ElevatorObserver observer : observers){
            observer.onElevatorFloorChange(this, this.currentfloor);
        }
    }

    boolean checkstatechange(Request request) {
        if(requests.isEmpty()){
            return false;
        }
        if(this.direction == Direction.IDLE){
            return true;
        }
        if(this.direction == Direction.UP && request.getTargetFloor() < this.currentfloor){
            return true;
        }
        if(this.direction == Direction.DOWN && request.getTargetFloor() > this.currentfloor){
            return true;
        }
        return false;
    }

    void moveToNextfloor(int targetfloor) {
        if (state == State.IDLE) return;

        if (this.currentfloor < targetfloor) {
            this.currentfloor++;
            this.direction = Direction.UP;
        } else if (this.currentfloor > targetfloor) {
            this.currentfloor--;
            this.direction = Direction.DOWN;
        }

        notifyforfloorchange();

        if (this.currentfloor == targetfloor) {
            complete_request();
        }
    }

    void complete_request() {
        this.state = State.STOPPED;
        requests.poll();
        notifyforstatechange();

        if (requests.isEmpty()) {
            this.direction = Direction.IDLE;
            this.state = State.IDLE;
        } else {
            this.state = State.MOVING;
        }
    }
    public List<Integer> getDestinationFloors() {
        List<Integer> floors = new ArrayList<>();
        for (Request r : requests) {
            floors.add(r.getTargetFloor());
        }
        return floors;
    }
}
