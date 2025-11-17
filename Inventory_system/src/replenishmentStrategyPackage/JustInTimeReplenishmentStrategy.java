package replenishmentStrategyPackage;

import utilityClasses.Product;

public class JustInTimeReplenishmentStrategy implements ReplenishmentStrategy {

    @Override
    public void replenish(Product product) {
        System.out.println("Replenishing product with id " + product.getId() + " in time");
    }
}
