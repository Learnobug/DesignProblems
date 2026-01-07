public abstract class Request {
    double time_stamp;
    RequestState state;
    double weight;
    double waiting_time;

    Request() {
        this.state = RequestState.PENDING;
        this.time_stamp = System.currentTimeMillis();
    }


    public double getTimeStamp() {
        return time_stamp;
    }
    abstract int getTargetFloor();
    public void calculatewaitingtime(){
        double current_time = System.currentTimeMillis();
        this.waiting_time = current_time - this.time_stamp;
    }
}
