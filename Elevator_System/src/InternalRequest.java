public class InternalRequest extends Request {
    int targetFloor;


    InternalRequest(int targetFloor) {
        this.targetFloor = targetFloor;
    }

    @Override
    public int getTargetFloor() {
        return targetFloor;
    }
}
