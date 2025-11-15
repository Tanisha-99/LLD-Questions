package factoryClasses;

import utilityClasses.Position;

public class FoodFactory {

    public static FoodItem createFoodItem(Position position, String type) {
        if(type.equals("normal")) {
            return new NormalFoodItem(position);
        } else if(type.equals("bonus")) {
            return new BonusFoodItem(position);
        }

        return new PosinousFoodItem(position);
    }
}
