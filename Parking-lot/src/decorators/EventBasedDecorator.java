package decorators;

import models.Ticket;
import strategies.ParkingFeeCalculationStrategy;

public class EventBasedDecorator extends ParkingFeeDecorator{

    private final double eventDayCharge;

    public EventBasedDecorator(ParkingFeeCalculationStrategy calculationStrategy, double eventDayCharge) {
        super(calculationStrategy);
        this.eventDayCharge = eventDayCharge;
    }

    public double calculateParkingFee(Ticket ticket) {
        double baseFare = super.calculateParkingFee(ticket);
        return baseFare + eventDayCharge;
    }
}
