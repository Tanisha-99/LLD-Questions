package strategies.impl;

import models.Ticket;
import strategies.ParkingFeeCalculationStrategy;

import java.time.Duration;
import java.time.Instant;

public class HourlyParkingFeeCalculationStrategy implements ParkingFeeCalculationStrategy {

    @Override
    public double calculateParkingFee(Ticket ticket) {
        Instant entryTime = ticket.getEntryTime();
        Instant exitTime = Instant.now();

        Duration duration = Duration.between(entryTime, exitTime);

        double hours = duration.toMinutes() / 60.0;
        double baseFare = ticket.getParkingSlot().getVehicle().getBaseRate();

        return baseFare * hours;
    }
}
