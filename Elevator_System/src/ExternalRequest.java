public class ExternalRequest extends Request {
    int requestedFloor;
    Direction direction;

    ExternalRequest(int requestedFloor, Direction direction) {
        this.requestedFloor = requestedFloor;
        this.direction = direction;
    }

    @Override
    public int getTargetFloor() {
        return requestedFloor;
    }

    public Direction getDirection() {
        return direction;
    }

}
