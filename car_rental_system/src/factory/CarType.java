package factory;

public enum CarType {
    NORMAL(10),
    LUXURY(30),
    PREMIUM(20);

    private double baseFare;

    CarType(double baseFare) {
        this.baseFare = baseFare;
    }

    public double getBaseFare() {
        return baseFare;
    }

    public VehicleFactory getFactory() {
        return new CarFactory(this);
    }
}
