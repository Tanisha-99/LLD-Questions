package utilityClasses;

import MovementStrategyPackage.MovementStrategy;

public class Board {

    private int width;
    private int height;
    private Snake snake;
    private Food food;
    private MovementStrategy movementStrategy;

    public Board(int width, int height, Food food, MovementStrategy movementStrategy){
        this.width = width;
        this.height = height;
        this.food = food;
        this.snake = new Snake();
        this.movementStrategy = movementStrategy;
    }

    public Snake getSnake() {
        return snake;
    }

    public int makeMove(Direction direction) {
        Position currentHead = snake.getBody().peekFirst();

        Position newHead = movementStrategy.getNextPosition(currentHead, direction);
        int newRow = newHead.getRow();
        int newColumn = newHead.getColumn();

        boolean isBoundaryCrossed = newRow < 0 || newColumn < 0 || newRow >= width || newColumn >= height;

        Position tail = snake.getBody().peekLast();
        boolean isKilled = snake.getPositionMap().containsKey(newHead) && !(newRow == tail.getRow() && newColumn == tail.getColumn());

        if(isBoundaryCrossed || isKilled){
            return -1;
        }

        int foodIndex = food.getCurrentFoodIndex();
        Position foodPosition = food.getFoodPositions().get(foodIndex);

        boolean ateFood = (foodIndex < food.getFoodPositions().size()) && foodPosition.getRow() == newRow && foodPosition.getColumn() == newColumn;

        if(ateFood){
            food.setCurrentFoodIndex(foodIndex + 1);
        } else {
            snake.getBody().pollLast();
            snake.getPositionMap().remove(tail);
        }

        snake.getBody().addFirst(newHead);
        snake.getPositionMap().put(newHead, true);

        int score = snake.getBody().size() - 1;
        return score;
    }
}
