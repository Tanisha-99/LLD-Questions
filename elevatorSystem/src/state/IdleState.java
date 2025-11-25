package state;

import models.Direction;
import models.Elevator;
import models.ElevatorRequest;

public class IdleState implements ElevatorState{
    @Override
    public void move(Elevator elevator) {
        if (!elevator.getUpRequests().isEmpty()) {
            elevator.setState(new MovingUpState());
        } else if (!elevator.getDownRequests().isEmpty()) {
            elevator.setState(new MovingDownState());
        }
        // Else stay idle
    }

    @Override
    public void addRequest(Elevator elevator, ElevatorRequest request) {
        if (request.getFloor() > elevator.getCurrentFloor()) {
            elevator.getUpRequests().add(request.getFloor());
        } else if (request.getFloor() < elevator.getCurrentFloor()) {
            elevator.getDownRequests().add(request.getFloor());
        }
        // If request is for current floor, doors would open (handled implicitly by moving to that floor)
    }

    @Override
    public Direction getDirection() { return Direction.IDLE; }
}
