public class User {
    int id;
    int currentFloor;
    double weight;

    User(int currentFloor, double weight){
        this.currentFloor = currentFloor;
        this.weight = weight;
        this.id = Math.toIntExact((long) (Math.random()*100));
    }
}
