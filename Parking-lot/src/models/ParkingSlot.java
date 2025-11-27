package models;

public abstract class ParkingSlot {
    private int id;
    private VehicleType slotType;
    private boolean isOccupied;
    private Vehicle vehicle;

    public ParkingSlot(int id, VehicleType slotType) {
        this.id = id;
        this.slotType = slotType;
        this.vehicle = null;
        this.isOccupied = false;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public VehicleType getSlotType() {
        return slotType;
    }

    public int getId() {
        return id;
    }

    public abstract boolean canParkVehicle(Vehicle vehicle);

    public void parkVehicle(Vehicle vehicle) {
        if(isOccupied) {
            throw new IllegalStateException("Parking already occupied");
        }

        if(!canParkVehicle(vehicle)) {
            throw new IllegalStateException("parking lot is not suitable for vehicle");
        }

        this.vehicle = vehicle;
        isOccupied = true;
    }

    public void vacate(Vehicle vehicle) {
        if(!isOccupied) {
            throw new IllegalStateException("Parking not occupied");
        }

        if(!vehicle.equals(this.vehicle)) {
            throw new IllegalStateException("Invalid operation, vehicle does not match parked vehicle");
        }

        this.vehicle = null;
        isOccupied = false;
    }
}
