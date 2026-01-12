//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    PaymentStrategy paymentStrategy = new UPIPayment();
    Customer customer = new Customer("John Doe", "8223456789", "D1234567");
    Car car = new Car("Toyota", CarType.SUV, "Camry", "ABC123", 50.0);
    Car car1 = new Car("Honda", CarType.SIDAN, "Civic", "XYZ789", 40.0);
    Controller controller = Controller.getInstance();
    controller.addnewcar(car);
    controller.addnewcar(car1);

    controller.ListALLCars();
    //filter search
    Filter filter = new FilterBuilder().setPrice(40).build();
    List<Car> availableCars = controller.searchCars(filter);
    System.out.println("Available Cars after applying filter:");
    displayCarInfo(availableCars);
    System.out.println("-----------------------------------");
    Date startDate = new GregorianCalendar(2024, Calendar.JULY, 1).getTime();
    Date endDate = new GregorianCalendar(2024, Calendar.JULY, 5).getTime();
    Reservation reservation = controller.createReservation(car, startDate, endDate, customer, paymentStrategy);

    if (reservation != null) {
        reservation.processPayment();
    } else {
        System.out.println("Car cannot be reserved for the selected dates.");
    }
}

public void displayCarInfo(List<Car> cars) {
    for (Car car : cars) {
        System.out.println("Car Name: " + car.getName() + ", Model: " + car.getModel() + ", Type: " + car.getType() + ", Price: " + car.getPrice());
    }
}