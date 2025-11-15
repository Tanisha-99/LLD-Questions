package MovementStrategyPackage;

import utilityClasses.Direction;
import utilityClasses.Position;

public class AIMovementStrategy implements MovementStrategy {

    @Override
    public Position getNextPosition(Position currentHead, Direction direction) {
        /*
        AI logic to determine next best move based on food positions and obstacles

        for simplicity it can implement a basic path finding algorithm or just random movement that avoids obstacles.
         */

        return currentHead;
    }
}
