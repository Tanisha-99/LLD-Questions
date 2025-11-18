//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

    }
}



/*
1. should support different types of cars - seater
2. different type of pricing strategy - hourly / day wise / km wise
3. with/without driver
4. process payments
5. multiple rental stores
6. search for available vehicle based on location, date range and preferences
7. filter and sort vehicles based on price, type and feature
8. create modify and cancel reservations.
9. generates bills
10. Reservation conflicts
11. User authentication


First interaction -
Here is my understanding
1. System will manage multiple vehicles across different rental locations
2. User can search, filter and reserve vehicles based on their preferences.
3. system tracks vehicle availability and prevent booking conflicts
4. billing payment processing
5. system should be scalable to handle operations across different cities.

Next interaction -

I want to clarify a few requirements:
1. What type of vehicle should the system support ?
2. Should the system support multiple vehicle types - or it is designed for just cars
3. How should the system handle reservation modification and cancellation
4. Are there specific pricing strategies for different vehicle types.


Entities:
1. Vehicle
2. Car
3. Car type
4. Ticket
5. Price strategy
6. Shop
7. Car rental manager
8. Reservation
9. Reservation manager


Design patterns:
1. factory for vehicle creation - might be overkill
2. strategy for payment and pricing
3. singleton for rental system
4. Observer for notifying users

 */