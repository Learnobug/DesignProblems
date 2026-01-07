import java.util.List;
import java.util.Queue;

public class Elevator {
    int uniqid;
    int currentfloor;
    int targetfloor;
    Direction direction;
    State state;
    int capacity;
    Queue<Request> requests = new java.util.LinkedList<>();
    List<ElevatorObserver> observers = new java.util.ArrayList<>();
    SchedulingStrategy schedulingStrategy;

    Elevator( int capacity, SchedulingStrategy schedulingStrategy) {
        this.uniqid = Math.toIntExact(Math.round(Math.random() * 100));
        this.currentfloor = 0;
        this.targetfloor = 0;
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

    public Request processrequest() {
        if(requests.isEmpty()){
            this.state = State.IDLE;
            this.direction = Direction.IDLE;
            return null;
        }
        Request processedRequest = requests.peek();
        boolean checkstatechange = checkstatechange(processedRequest);
        this.targetfloor = getnextFloor();
        processedRequest.calculatewaitingtime();
        this.currentfloor = this.targetfloor;

        requests.remove(processedRequest);

        if (checkstatechange) {
            notifyforstatechange();
        }
        notifyforfloorchange();

        return processedRequest;
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
}
