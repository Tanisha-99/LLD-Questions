package factory;

public class CarFactory implements VehicleFactory {

    private CarType carType;

    public CarFactory(CarType carType) {
        this.carType = carType;
    }

    @Override
    public Vehicle createVehicle(String regNo, String model, String year) {
        return new Car(regNo, model, year, carType);
    }
}

