package pricingStrategy;

import factory.Vehicle;

import java.util.Date;

public interface PricingStrategy {
    double getPrice(Date startDate, Date endDate, Vehicle vehicle);
}
