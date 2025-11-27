package models;

public class TwoWheelerParkingSpot extends ParkingSlot{

    public TwoWheelerParkingSpot(int id) {
        super(id, VehicleType.TWO_WHEELER);
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return vehicle.getVehicleType() == VehicleType.TWO_WHEELER;
    }
}
