//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    User user1 = new User(3, 70.5);
    User user2 = new User(5, 80.0);

    SchedulingStrategy strategy = new FCFS();
    ElevatorController controller = new ElevatorController(10 , strategy);
    Elevator elevator1 = new Elevator(500, strategy);
    controller.addElevator(elevator1);
    ElevatorObserver observer = new ElevatorObserver();
    elevator1.addObserver(observer);

    Scanner scanner = new Scanner(System.in);
    boolean running = true;

    while (running) {
        System.out.println("Enter command (request/exit/stimulate(s)): ");
        String command = scanner.nextLine();

        if (command.equalsIgnoreCase("request")) {
            System.out.println("Choose Internal or External Request (i/e): ");
            String requestType = scanner.nextLine();
            Request request;
            if(requestType.equalsIgnoreCase("i")){
                System.out.println("Enter floor number: ");
                int floorNumber = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                request = new InternalRequest(floorNumber);
            }else if(requestType.equalsIgnoreCase("e")){
                System.out.println("Enter floor number: ");
                int floorNumber = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.println("Enter direction (UP/DOWN): ");
                String dir = scanner.nextLine();
                Direction direction = dir.equalsIgnoreCase("UP") ? Direction.UP : Direction.DOWN;
                request = new ExternalRequest(floorNumber, direction);
            }else{
                System.out.println("Invalid request type.");
                continue;
            }

            elevator1.addRequest(request);
        }else if(command.equalsIgnoreCase("s")){
            controller.step();
            displayElevatorStatus(
                    controller.getElevator());
        }
        else if (command.equalsIgnoreCase("exit")) {
            running = false;
        } else {
            System.out.println("Unknown command.");
        }
    }



}
void displayElevatorStatus(Elevator elevator) {
    System.out.println("nElevator Status:");

    // Print details of each elevator, including current floor, direction, and
    // state
    System.out.println("Elevator " + elevator.getId() + ": Floor "
            + elevator.getCurrentfloor() + ", Direction "
            + elevator.getDirection() + ", State " + elevator.getState()
            + ", Destinations " + elevator.getDestinationFloors());

}
