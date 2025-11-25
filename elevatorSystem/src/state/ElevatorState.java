package state;

import models.Direction;
import models.Elevator;
import models.ElevatorRequest;

public interface ElevatorState {
    void move(Elevator elevator);
    void addRequest(Elevator elevator, ElevatorRequest elevatorRequest);
    Direction getDirection();
}
