package factories;

import decorators.ParkingFeeDecorator;
import models.FourWheelerVehicle;
import models.TwoWheelerVehicle;
import models.Vehicle;
import models.VehicleType;

public class VehicleFactory {
    public static Vehicle createVehicle(String vehicleNumber, VehicleType vehicleType, ParkingFeeDecorator parkingFeeDecorator) {
        if(vehicleType == VehicleType.TWO_WHEELER) {
            return new TwoWheelerVehicle(vehicleNumber, parkingFeeDecorator);
        }

        return new FourWheelerVehicle(vehicleNumber, parkingFeeDecorator);
    }
}
