import models.ParkingSlot;
import models.Ticket;
import models.Vehicle;
import models.VehicleType;

import java.time.Instant;
import java.util.List;

public class ParkingLot {


    //currently just one floor but if we had multiple floors then this would contain list of floors and floors would contain list of spots
    private List<ParkingSlot> parkingSlots;

    public ParkingLot(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public ParkingSlot findAvailableSlot(Vehicle vehicle) {
        for (ParkingSlot parkingSlot : parkingSlots) {
            if(!parkingSlot.isOccupied() && parkingSlot.getSlotType().equals(vehicle.getVehicleType())) {
                return parkingSlot;
            }
        }

        return null;
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        ParkingSlot slot = findAvailableSlot(vehicle);

        if(slot != null) {
            slot.parkVehicle(vehicle);
            System.out.println("Vehicle with number: " + vehicle.getVehicleNumber() + " parked on slot: " + slot.getId());
            return new Ticket(slot, Instant.now());
        }

        System.out.println("No parking slot available for vehicle: " + vehicle.getVehicleNumber());
        return null;
    }

    public void vacateSpot(Vehicle vehicle, ParkingSlot slot) {
        if(slot != null ) {
            slot.vacate(vehicle);
            System.out.println("Vehicle with number: " + vehicle.getVehicleNumber() + " removed from slot: " + slot.getId());
        }
    }
}
