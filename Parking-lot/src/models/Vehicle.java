package models;

import decorators.ParkingFeeDecorator;

public abstract class Vehicle {
    private String vehicleNumber;
    private VehicleType vehicleType;
    private ParkingFeeDecorator parkingFeeDecorator;

    public Vehicle(String vehicleNumber, VehicleType vehicleType, ParkingFeeDecorator parkingFeeDecorator) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.parkingFeeDecorator = parkingFeeDecorator;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public double getBaseRate() {
        return vehicleType.getBaseRate();
    }

    public double getFee(Ticket ticket) {
        return parkingFeeDecorator.calculateParkingFee(ticket);
    }
}
