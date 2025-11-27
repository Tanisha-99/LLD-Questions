package strategies;

import models.Ticket;

import java.time.Instant;

public interface ParkingFeeCalculationStrategy {
    double calculateParkingFee(Ticket ticket);
}
