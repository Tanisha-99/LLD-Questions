package managers;

import models.Direction;
import models.Elevator;
import models.ElevatorRequest;
import models.RequestSource;
import strategy.elevatorSelection.ElevatorSelectionStrategy;

import java.util.*;
import java.util.concurrent.ExecutorService;

public class ElevatorManager {
    private Map<Integer, Elevator> elevators;
    private ElevatorSelectionStrategy elevatorSelectionStrategy;
    private ExecutorService executorService;

    public ElevatorManager(ElevatorSelectionStrategy elevatorSelectionStrategy, ExecutorService executorService) {
        this.elevatorSelectionStrategy = elevatorSelectionStrategy;
        this.elevators = new HashMap<>();
        this.executorService = executorService;
    }

    public void addElevator(Elevator elevator) {
        elevators.put(elevator.getId(), elevator);
    }

    public void start() {
        for(Elevator elevator: elevators.values()) {
            executorService.submit(elevator);
        }
    }

    public void requestElevator(int floor, Direction direction) {
        System.out.println("\n>> EXTERNAL Request: User at floor " + floor + " wants to go " + direction);
        ElevatorRequest request = new ElevatorRequest(RequestSource.EXTERNAL, direction, floor);

        // Use strategy to find the best elevator
        Optional<Elevator> selectedElevator = elevatorSelectionStrategy.selectElevator(new ArrayList<>(elevators.values()), request);

        if(selectedElevator.isPresent()) {
            selectedElevator.get().addRequest(request);
        } else {
            System.out.println("System busy, please wait.");
        }
    }

    public void requestFloor(int id, int floor) {
        System.out.println("\n>> INTERNAL request: User in elevator " + id + " selected floor " + floor);
        ElevatorRequest elevatorRequest = new ElevatorRequest(RequestSource.INTERNAL, Direction.IDLE, floor);
        Elevator elevator = elevators.get(id);

        if(elevator != null) {
            elevator.addRequest(elevatorRequest);
        }
        else {
            System.out.println("invalid elevator: " + id);
        }
    }

    public void shutDown() {
        System.out.println("Shutting down elevator system");

        for(Elevator elevator: elevators.values()) {
            elevator.stopElevator();
        }

        executorService.shutdown();
    }

    public Elevator getElevatorById(int id) {
        return elevators.get(id);
    }
    
}
