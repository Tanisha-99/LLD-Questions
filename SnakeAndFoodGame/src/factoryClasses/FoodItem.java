package factoryClasses;

import utilityClasses.Position;

public abstract class FoodItem {
    protected Position position;
    protected double points;

    public FoodItem(Position position, double points) {
        this.position = position;
        this.points = points;
    }

    public Position getPosition() {
        return position;
    }

    public double getPoints() {
        return points;
    }
}
