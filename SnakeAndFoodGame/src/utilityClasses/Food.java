package utilityClasses;

import java.util.List;

public class Food {
    private List<Position> foodPositions; // can generate random too
    private int currentFoodIndex;

    public Food(List<Position> foodPositions) {
        this.foodPositions = foodPositions;
        this.currentFoodIndex = 0;
    }

    public List<Position> getFoodPositions() {
        return foodPositions;
    }

    public int getCurrentFoodIndex() {
        return currentFoodIndex;
    }

    public void setCurrentFoodIndex(int currentFoodIndex) {
        this.currentFoodIndex = currentFoodIndex;
    }
}
