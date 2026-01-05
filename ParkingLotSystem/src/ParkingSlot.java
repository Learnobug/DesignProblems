import java.util.List;

public class ParkingSlot {
    int TotalLots;
    List<ParkingLot> parkingLots = new java.util.ArrayList<>();
    VehicleType vehicleType;

    ParkingSlot(int TotalLots, VehicleType vehicleType) {
        this.TotalLots = TotalLots;
        this.vehicleType = vehicleType;
        for(int i=0;i<TotalLots;i++){
            this.parkingLots.add(new ParkingLot(i,vehicleType,getParkingfeeStrategy(vehicleType)));
        }
    }

    public boolean CheckAvailability() {
        for (ParkingLot lot : parkingLots) {
            if (!lot.isOccupied && lot.vehicleType == this.vehicleType) {
                return true;
            }
        }
        return false;
    }

    public ParkingLot GetAvailableLot() {
        for (ParkingLot lot : parkingLots) {
            if (!lot.isOccupied && lot.vehicleType == this.vehicleType) {
                return lot;
            }
        }
        return null;
    }

    public void AddParkingLot(ParkingLot lot) {
        if (parkingLots.size() < TotalLots && lot.vehicleType == this.vehicleType) {
            parkingLots.add(lot);
        }
    }

    public ParkingLot assignParkingLot(ParkingLot lot, User user, ParkingfeeStrategy strategy) {
        if (!lot.isOccupied && lot.vehicleType == this.vehicleType) {
            lot.isOccupied = true;
            lot.user = user;
            lot.parkingfeeStrategy = strategy;
        }
        return lot;
    }

    public ParkingfeeStrategy getParkingfeeStrategy(VehicleType vh) {
        switch (vh) {
            case CAR:
                return new HourlyfeeStrategy(5.0);
            case Bike:
                return new HourlyfeeStrategy(2.0);
        }
        return new FixedfeeStrategy(20.0);
    }
}
