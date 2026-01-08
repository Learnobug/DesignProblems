import java.util.Date;
import java.util.List;

public class Car {
    String Model;
    CarType Type;
    String name;
    String licenseplate;
    double price;
    ReservationState state;
    List<Reservation> reservations = new java.util.ArrayList<>();

    Car(String Model,CarType Type,String name,String licenseplate,double price){
        this.Model = Model;
        this.Type = Type;
        this.name = name;
        this.licenseplate = licenseplate;
        this.price = price;
        this.state = ReservationState.AVAILABLE;
    }

    public void setState(ReservationState state){
        this.state = state;
    }

    public boolean Canreserve(Date start, Date end){
        for(Reservation reservation : reservations){
            if(checkDateOverlap(start, end, reservation.getStartDate(), reservation.getEndDate())){
                return false;
            }
        }
        return true;
    }

    private boolean checkDateOverlap(Date start1, Date end1, Date start2, Date end2) {
        return start1.before(end2) && start2.before(end1);
    }

    public void makeReservation(Reservation reservation){
        this.reservations.add(reservation);
    }

    public void displayreservations(){
        for(Reservation reservation : reservations){
            System.out.println("Reservation for car: " + this.name + " from " + reservation.getStartDate() + " to " + reservation.getEndDate());
        }
    }

    public String getModel() {
        return Model;
    }

    public CarType getType() {
        return Type;
    }

    public double getPrice() {
        return price;
    }

    public String getName(){
        return name;
    }
}
