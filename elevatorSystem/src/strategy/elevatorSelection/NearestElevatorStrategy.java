package strategy.elevatorSelection;

import models.Direction;
import models.Elevator;
import models.ElevatorRequest;

import java.util.List;
import java.util.Optional;

public class NearestElevatorStrategy implements ElevatorSelectionStrategy{
    @Override
    public Optional<Elevator> selectElevator(List<Elevator> elevators, ElevatorRequest elevatorRequest) {
        Elevator bestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            if (isSuitable(elevator, elevatorRequest)) {
                int distance = Math.abs(elevator.getCurrentFloor() - elevatorRequest.getFloor());
                if (distance < minDistance) {
                    minDistance = distance;
                    bestElevator = elevator;
                }
            }
        }
        return Optional.ofNullable(bestElevator);
    }

    private boolean isSuitable(Elevator elevator, ElevatorRequest elevatorRequest) {
        if (elevator.getDirection() == Direction.IDLE)
            return true;
        if (elevator.getDirection() == elevatorRequest.getDirection()) {
            if (elevatorRequest.getDirection() == Direction.UP && elevator.getCurrentFloor() <= elevatorRequest.getFloor())
                return true;
            if (elevatorRequest.getDirection() == Direction.DOWN && elevator.getCurrentFloor() >= elevatorRequest.getFloor())
                return true;
        }
        return false;
    }

}
