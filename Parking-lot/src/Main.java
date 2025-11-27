import decorators.EventBasedDecorator;
import decorators.NormalDaysDecorator;
import decorators.ParkingFeeDecorator;
import factories.VehicleFactory;
import models.*;
import strategies.ParkingFeeCalculationStrategy;
import strategies.PaymentStrategy;
import strategies.impl.CashPaymentStrategy;
import strategies.impl.FixedParkingFeeCalculationStrategy;
import strategies.impl.HourlyParkingFeeCalculationStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome to PArking lot!");

        List<ParkingSlot> parkingSpots = new ArrayList<>();
        parkingSpots.add(new FourWheelerParkingSpot(1));
        parkingSpots.add(new FourWheelerParkingSpot(2));
        parkingSpots.add(new TwoWheelerParkingSpot(3));
        parkingSpots.add(new TwoWheelerParkingSpot(4));

        ParkingLot parkingLot = new ParkingLot(parkingSpots);

        ParkingFeeCalculationStrategy fixedFeeStrategy = new FixedParkingFeeCalculationStrategy();
        ParkingFeeCalculationStrategy hourlyFeeStrategy = new HourlyParkingFeeCalculationStrategy();

        ParkingFeeDecorator normalFeeDecoratorWithFixedStrategy = new NormalDaysDecorator(fixedFeeStrategy);
        ParkingFeeDecorator normalFeeDecoratorWithHourlyStrategy = new NormalDaysDecorator(hourlyFeeStrategy);

        ParkingFeeDecorator eventFeeDecoratorWithFixedStrategy = new EventBasedDecorator(fixedFeeStrategy, 10.5);
        ParkingFeeDecorator eventFeeDecoratorWithHourlyStrategy = new EventBasedDecorator(hourlyFeeStrategy, 10.5);

        Vehicle car1 = VehicleFactory.createVehicle("CAR1", VehicleType.FOUR_WHEELER, normalFeeDecoratorWithFixedStrategy);
        Vehicle bike1 = VehicleFactory.createVehicle("BIKE1", VehicleType.TWO_WHEELER, normalFeeDecoratorWithFixedStrategy);

        Ticket car1Ticket = parkingLot.parkVehicle(car1);
        Ticket bike1Ticket = parkingLot.parkVehicle(bike1);

        Scanner scanner =  new Scanner(System.in);

        if(car1Ticket.getParkingSlot() != null) {
            double car1Fee = car1.getFee(car1Ticket);
            PaymentStrategy cashPaymentStrategy = new CashPaymentStrategy();
            cashPaymentStrategy.pay(car1Fee);
            parkingLot.vacateSpot(car1, car1Ticket.getParkingSlot());
        }
    }


    /*
        Requirements:
        1. System manages different vehicle Types
        2. Vehicles enter and exit after making payment
        3. Parking slot is assigned upon entry and freed on exit
        4. Payment must be completed before leaving
        5. The system handles different vehicle sizes and available slots efficiently.
         */

        /*
        Clarifications
        1. will there be multiple slot types for different vehicle sizes.
        2. are we supporting multiple payment methods
        3. should the system track the parking duration
        4. can there be multiple floors in the lot
         */

        /*
        Entities

        1. Vehicle
        2. Vehicle Type - Enum
        3. Parking slot
        4. Ticket
        5. Parking lot
         */

        /*
        Design patterns

        1. Strategy - payment, fee calculation
        2. Factory - vehicle creation
        3. can use decorator as well for fee calculation
        4. Observer pattern for exit notification to the system
         */
}