package models;

public enum VehicleType {
    TWO_WHEELER(5),
    FOUR_WHEELER(10);

    private final double baseRate;

    VehicleType(double baseHourlyRate) {
        this.baseRate = baseHourlyRate;
    }

    public double getBaseRate() {
        return baseRate;
    }
}
