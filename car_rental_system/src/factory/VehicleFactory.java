package factory;

public interface VehicleFactory {
    Vehicle createVehicle(String regNo, String model, String year);
}
