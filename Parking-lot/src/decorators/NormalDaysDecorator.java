package decorators;

import models.Ticket;
import strategies.ParkingFeeCalculationStrategy;

public class NormalDaysDecorator extends ParkingFeeDecorator{

    public NormalDaysDecorator(ParkingFeeCalculationStrategy calculationStrategy) {
        super(calculationStrategy);
    }

    public double calculateParkingFee(Ticket ticket) {
        return super.calculateParkingFee(ticket);
    }
}
