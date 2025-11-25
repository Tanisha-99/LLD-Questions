package observer;

import models.Elevator;
import state.ElevatorState;

public interface ElevatorObserver {
    void onElevatorStateChange(Elevator elevator, ElevatorState state);

    void onElevatorFloorChange(Elevator elevator, int floor);
}
