package MovementStrategyPackage;

import utilityClasses.Direction;
import utilityClasses.Position;

public interface MovementStrategy {
    Position getNextPosition(Position currentHead, Direction direction);
}
