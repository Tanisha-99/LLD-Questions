package state;

import models.Direction;
import models.Elevator;
import models.ElevatorRequest;
import models.RequestSource;

public class MovingDownState implements ElevatorState{
    @Override
    public void move(Elevator elevator) {
        if (elevator.getDownRequests().isEmpty()) {
            elevator.setState(new IdleState());
            return;
        }

        Integer nextFloor = elevator.getDownRequests().first();
        elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);

        if (elevator.getCurrentFloor() == nextFloor) {
            System.out.println("Elevator " + elevator.getId() + " stopped at floor " + nextFloor);
            elevator.getDownRequests().pollFirst();
        }

        if (elevator.getDownRequests().isEmpty()) {
            elevator.setState(new IdleState());
        }
    }

    @Override
    public void addRequest(Elevator elevator, ElevatorRequest request) {
        // Internal requests always get added to the appropriate queue
        if (request.getSource() == RequestSource.INTERNAL) {
            if (request.getFloor() > elevator.getCurrentFloor()) {
                elevator.getUpRequests().add(request.getFloor());
            } else {
                elevator.getDownRequests().add(request.getFloor());
            }
            return;
        }

        // External requests
        if (request.getDirection() == Direction.DOWN && request.getFloor() <= elevator.getCurrentFloor()) {
            elevator.getDownRequests().add(request.getFloor());
        } else if (request.getDirection() == Direction.UP) {
            elevator.getUpRequests().add(request.getFloor());
        }
    }

    @Override
    public Direction getDirection() { return Direction.DOWN; }
}
