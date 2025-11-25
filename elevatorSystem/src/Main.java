import managers.Building;
import models.Direction;
import models.Elevator;
import strategy.elevatorSelection.ElevatorSelectionStrategy;
import strategy.elevatorSelection.NearestElevatorStrategy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ElevatorSelectionStrategy elevatorSelectionStrategy = new NearestElevatorStrategy();
        Building building = new Building("Stellar Jeevan", 5,2 , elevatorSelectionStrategy);

        for(int i = 1; i <= 5; i++) {
            Elevator elevator = new Elevator(i, 5);
            building.addElevator(elevator);
        }

        building.getElevatorManager().start();

        System.out.println("Elevator system started. ConsoleDisplay is observing.\n");

        building.requestElevator(5, Direction.UP);
        Thread.sleep(100); // Wait for the elevator to start moving

        // 2. Internal Request: Assume E1 took the previous request.
        // The user gets in at floor 5 and presses 10.
        // We send this request directly to E1.

        // Note: In a real simulation, we'd wait until E1 reaches floor 5, but for this demo,
        // we simulate the internal button press shortly after the external one.
        building.requestFloor(1, 10);
        Thread.sleep(200);

        // 3. External Request: User at floor 3 wants to go DOWN.
        // E2 (likely still idle at floor 1) might take this, or E1 if it's convenient.
        building.requestElevator(3, Direction.DOWN);
        Thread.sleep(300);

        // 4. Internal Request: User in E2 presses 1.
        building.requestFloor(2, 1);

        // Let the simulation run for a while to observe the display updates
        System.out.println("\n--- Letting simulation run for 1 second ---");
        Thread.sleep(1000);

        // Shutdown the system
        building.getElevatorManager().shutDown();
        System.out.println("\n--- SIMULATION END ---");
    }
}

/*
Entities:

1. Building
2. Elevator
3. Elevator Manager
4. Elevator Request
5. RequestSource - enum - Internal/External
6. Direction - UP/ Down/ Idle

Design Patterns:
1. Observer
2. Strategy for elevator selection and movement
 */