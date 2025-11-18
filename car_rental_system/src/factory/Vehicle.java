package factory;

import utilityPackage.Reservation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Vehicle {
    private String registrationNumber;
    private String model;
    private String year;
    private VehicleType vehicleType;
    private VehicleStatus vehicleStatus;
    private List<Reservation> vehicleReservations;

    public Vehicle(String registrationNumber, String model, String year, VehicleType vehicleType) {
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.year = year;
        this.vehicleType = vehicleType;
        this.vehicleStatus = VehicleStatus.AVAILABLE;
        this.vehicleReservations = new ArrayList<>();
    }

    public boolean isAvailable(Date start, Date end) {
        for (Reservation r : vehicleReservations) {
            if(r.overlaps(start, end)) {
                return false;
            }
        }

        return true;
    }

    public void addReservation(Reservation vehicleReservation) {
        vehicleReservations.add(vehicleReservation);
    }
    public void removeReservation(Reservation vehicleReservation) {
        vehicleReservations.remove(vehicleReservation);
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }
}
