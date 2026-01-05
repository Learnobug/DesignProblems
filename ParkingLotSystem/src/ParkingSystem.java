import java.util.HashMap;
import java.util.Map;

public class ParkingSystem {
    Map<VehicleType, ParkingSlot> parkingSlots;

    ParkingSystem() {

    }

    public void addParkingSlot(ParkingSlot slot) {
        if (parkingSlots == null) {
            parkingSlots = new HashMap<>();
        }
        parkingSlots.put(slot.vehicleType, slot);
    }


    public boolean parkVehicle(User user, Vehicle vehicle,ParkingfeeStrategy strategy) {
        VehicleType vehicleType = user.getVehicleType();
        ParkingSlot slot = parkingSlots.get(vehicleType);
        if (slot != null && slot.CheckAvailability()) {
            ParkingLot lot = slot.GetAvailableLot();
            slot.assignParkingLot(lot, user,strategy);
            return true;
        }
        return false;
    }

    public void unparkVehicle(User user, Vehicle vehicle) {
        VehicleType vehicleType = user.getVehicleType();
        ParkingSlot slot = parkingSlots.get(vehicleType);
        if (slot != null) {
            for (ParkingLot lot : slot.parkingLots) {
                if (lot.isOccupied && lot.user.equals(user)) {
                    lot.isOccupied = false;
                    lot.user = null;
                    break;
                }
            }
        }
    }

    public double calculateParkingFee(User user, Vehicle vehicle, int hoursParked) {
        VehicleType vehicleType = user.getVehicleType();
        ParkingSlot slot = parkingSlots.get(vehicleType);
        if (slot != null) {
            for (ParkingLot lot : slot.parkingLots) {
                if (lot.isOccupied && lot.user.equals(user)) {
                    return lot.parkingfeeStrategy.calculateFee(hoursParked, vehicleType, false);
                }
            }
        }
        return 0.0;
    }
}
