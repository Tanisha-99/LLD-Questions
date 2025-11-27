package models;

import decorators.ParkingFeeDecorator;

public class TwoWheelerVehicle extends Vehicle {
    public TwoWheelerVehicle(String vechicleNumber, ParkingFeeDecorator feeDecorator) {
        super(vechicleNumber, VehicleType.TWO_WHEELER, feeDecorator);
    }
}
