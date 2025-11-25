package strategy.elevatorSelection;

import models.Elevator;
import models.ElevatorRequest;

import java.util.List;
import java.util.Optional;

public interface ElevatorSelectionStrategy {
    Optional<Elevator> selectElevator(List<Elevator> elevators, ElevatorRequest elevatorRequest);
}
