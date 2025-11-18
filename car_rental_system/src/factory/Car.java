package factory;

public class Car extends Vehicle {

    private CarType carType;

    public Car(String registrationNumber, String model, String year, CarType carType) {
        super(registrationNumber, model, year, VehicleType.CAR);
        this.carType = carType;
    }

    public CarType getCarType() {
        return carType;
    }
}
