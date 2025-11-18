package utilityPackage;

import factory.Vehicle;
import factory.VehicleStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class RentalStore {
    private String id;
    private String name;
    private Location location;
    private Map<String, Vehicle> vehicles; // registration no -> Vehicle

    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getRegistrationNumber(), vehicle);
    }

    public void removeVehicle(String registrationNumber) {
        vehicles.remove(registrationNumber);
    }

    public boolean isVehicleAvailable(String registrationNumber, Date startDate, Date endDate) {
        if(!vehicles.containsKey(registrationNumber)) {
            return false;
        }

        return vehicles.get(registrationNumber).isAvailable(startDate, endDate);
    }

    public List<Vehicle> getAvailableVehicles(Date startDate, Date endDate) {
        List<Vehicle> availableVehicles = new ArrayList<Vehicle>();

        for(Vehicle vehicle: vehicles.values()) {
            if(vehicle.getVehicleStatus() == VehicleStatus.AVAILABLE && vehicle.isAvailable(startDate, endDate)) {
                availableVehicles.add(vehicle);
            }
        }

        return availableVehicles;
    }

    public Vehicle getVehicle(String registrationNumber) {
        return vehicles.get(registrationNumber);
    }

    public String getId(){
        return id;
    }
}
