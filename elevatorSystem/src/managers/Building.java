package managers;

import models.Direction;
import models.Elevator;
import models.ElevatorRequest;
import models.RequestSource;
import observer.ElevatorDisplay;
import strategy.elevatorSelection.ElevatorSelectionStrategy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Building {
    private String name;
    private int numberOfFloors;
    private int numberOfElevators;
    private ElevatorManager elevatorManager;

    public Building(String name, int numberOfFloors, int numberOfElevators, ElevatorSelectionStrategy elevatorSelectionStrategy) {
        this.name = name;
        this.numberOfFloors = numberOfFloors;
        this.numberOfElevators = numberOfElevators;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfElevators);
        this.elevatorManager = new ElevatorManager(elevatorSelectionStrategy, executorService);
    }

    public void requestElevator(int floor, Direction direction) {
        elevatorManager.requestElevator(floor, direction);
    }

    public void requestFloor(int id, int floor) {
        elevatorManager.requestFloor(id, floor);
    }

    public void addElevator(Elevator elevator) {
        elevator.addObserver(new ElevatorDisplay());
        elevatorManager.addElevator(elevator);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public ElevatorManager getElevatorManager() {
        return elevatorManager;
    }

    public void setElevatorManager(ElevatorManager elevatorManager) {
        this.elevatorManager = elevatorManager;
    }
}
