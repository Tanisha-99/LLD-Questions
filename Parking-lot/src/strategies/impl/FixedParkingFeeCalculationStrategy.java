package strategies.impl;

import models.Ticket;
import strategies.ParkingFeeCalculationStrategy;

import java.time.Instant;

public class FixedParkingFeeCalculationStrategy implements ParkingFeeCalculationStrategy {

    public double calculateParkingFee(Ticket ticket) {
        return ticket.getParkingSlot().getVehicle().getBaseRate();
    }
}
