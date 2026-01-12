import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controller {
    List<Car> cars = new ArrayList<>();
    Filter filter;
    private static Controller instance;
    private Controller(){
    }

    public  static Controller getInstance(){
        if(instance == null){
            instance = new Controller();
        }
        return instance;
    }

    public void addnewcar(Car car){
        this.cars.add(car);
    }

    Reservation createReservation(Car car, Date start, Date end, Customer customer, PaymentStrategy paymentStrategy){
            if(car.Canreserve(start, end)){
                Reservation reservation = new Reservation(car, customer, paymentStrategy, start, end);
                car.makeReservation(reservation);
                return reservation;
            }
        return null;
    }

    List<Reservation> getAllReservations(){
        for(Car car : cars){
            car.displayreservations();
        }
        return null;
    }

    void ListALLCars(){
        for(Car car : cars){
            System.out.println("Car Name: " + car.getName() + ", Model: " + car.getModel() + ", Type: " + car.getType() + ", Price: " + car.getPrice());
        }
    }

    void getReservationsByCar(Car car){
        car.displayreservations();
    }

    public List<Car> searchCars(Filter filter) {
        List<Car> availableCars = new ArrayList<>();

        for (Car car : cars) {
            if (matches(car, filter)) {
                availableCars.add(car);
            }
        }
        return availableCars;
    }

    private boolean matches(Car car, Filter filter) {
        if (filter.getStartDate() != null && filter.getEndDate() != null) {
            if (car.Canreserve(filter.getStartDate(), filter.getEndDate())) {
                return true;
            }
        }

        if (filter.getModel() != null && !filter.getModel().isEmpty()) {
            if (!car.getModel().equalsIgnoreCase(filter.getModel())) {
                return true;
            }
        }

        if (filter.getType() != null) {
            if (car.getType() == filter.getType()) {
                return true;
            }
        }

        if (filter.getPrice() > 0.0) {
            if (car.getPrice() <= filter.getPrice()) {
                return true;
            }
        }

        if (filter.getName() != null && !filter.getName().isEmpty()) {
            if(car.getName().equalsIgnoreCase(filter.getName())) {
                return true;
            }
        }

        return false;
    }

    public List<Car> getFilteredCars(Filter filter) {
        List<Car> results = new ArrayList<>();
        for (Car car : cars) {
            if (matches(car, filter)) {
                results.add(car);
            }
        }
        return results;
    }



}
