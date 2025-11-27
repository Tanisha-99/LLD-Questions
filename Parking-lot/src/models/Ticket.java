package models;

import java.time.Instant;

public class Ticket {
    private ParkingSlot parkingSlot;
    private Instant entryTime;

    public Ticket(ParkingSlot parkingSlot, Instant entryTime) {
        this.parkingSlot = parkingSlot;
        this.entryTime = entryTime;
    }

    public Instant getEntryTime() {
        return entryTime;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }
}
