package models;

public class FourWheelerParkingSpot extends ParkingSlot{
    public FourWheelerParkingSpot(int id) {
        super(id, VehicleType.FOUR_WHEELER);
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return vehicle.getVehicleType() == VehicleType.FOUR_WHEELER;
    }
}
