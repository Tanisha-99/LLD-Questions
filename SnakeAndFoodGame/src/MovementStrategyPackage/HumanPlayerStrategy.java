package MovementStrategyPackage;

import utilityClasses.Direction;
import utilityClasses.Position;

public class HumanPlayerStrategy implements MovementStrategy{
    public Position getNextPosition(Position currentHead, Direction direction) {
        int row = currentHead.getRow();
        int column = currentHead.getColumn();

        switch (direction) {
            case UP :
                return new Position(row - 1, column);
            case DOWN:
                return new Position(row + 1, column);
            case LEFT:
                return new Position(row, column - 1);
            case RIGHT:
                return new Position(row, column + 1);
            default:
                return currentHead;
        }
    }
}
