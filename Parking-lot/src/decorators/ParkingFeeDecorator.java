package decorators;

import models.Ticket;
import strategies.ParkingFeeCalculationStrategy;

public abstract class ParkingFeeDecorator implements ParkingFeeCalculationStrategy {

    protected ParkingFeeCalculationStrategy parkingFeeCalculationStrategy;

    public ParkingFeeDecorator(ParkingFeeCalculationStrategy parkingFeeCalculationStrategy) {
        this.parkingFeeCalculationStrategy = parkingFeeCalculationStrategy;
    }

    public double calculateParkingFee(Ticket ticket) {
        return parkingFeeCalculationStrategy.calculateParkingFee(ticket);
    }
}
