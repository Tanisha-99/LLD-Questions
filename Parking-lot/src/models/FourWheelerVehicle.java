package models;

import decorators.ParkingFeeDecorator;

public class FourWheelerVehicle extends Vehicle{

    public FourWheelerVehicle(String vechicleNumber, ParkingFeeDecorator feeDecorator) {
        super(vechicleNumber, VehicleType.FOUR_WHEELER, feeDecorator);
    }
}
