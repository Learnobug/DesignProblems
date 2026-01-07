//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    User user1 = new User(3, 70.5);
    User user2 = new User(5, 80.0);

    SchedulingStrategy strategy = new FCFS();
    ElevatorController controller = new ElevatorController(10);
    Elevator elevator1 = new Elevator(500, strategy);
    controller.addElevator(elevator1);
    ElevatorObserver observer = new ElevatorObserver();
    elevator1.addObserver(observer);
    Request request1 = new ExternalRequest(2, Direction.UP);
    elevator1.addRequest(request1);
    Request request2 = new ExternalRequest(5, Direction.DOWN);
    elevator1.addRequest(request2);
    elevator1.processrequest();
    elevator1.processrequest();


}
