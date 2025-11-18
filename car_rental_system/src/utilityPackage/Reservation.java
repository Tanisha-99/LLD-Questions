package utilityPackage;

import factory.Vehicle;
import factory.VehicleStatus;
import paymentStrategy.PaymentStrategy;
import pricingStrategy.PricingStrategy;

import java.util.Date;
import java.util.UUID;

public class Reservation {
    private String id;
    private User user;
    private Vehicle vehicle;
    private RentalStore pickupRentalStore;
    private RentalStore dropRentalStore;
    private Date startDate;
    private Date endDate;
    private ReservationStatus reservationStatus;
    private double amount;
    private PricingStrategy pricingStrategy;
    private PaymentStrategy paymentStrategy;

    public Reservation(User user, Vehicle vehicle, RentalStore pickupRentalStore, RentalStore dropRentalStore, Date startDate, Date endDate) {
        this.id = UUID.randomUUID().toString();
        this.user = user;
        this.vehicle = vehicle;
        this.pickupRentalStore = pickupRentalStore;
        this.dropRentalStore = dropRentalStore;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reservationStatus = ReservationStatus.PENDING;
    }

    public void confirmReservation() {
        if(reservationStatus == ReservationStatus.PENDING) {
            reservationStatus = ReservationStatus.BOOKED;
            vehicle.setVehicleStatus(VehicleStatus.BOOKED);
            vehicle.addReservation(this);
        }
    }

    public void startRental() {
        if(reservationStatus == ReservationStatus.BOOKED) {
            reservationStatus = ReservationStatus.IN_PROGRESS;
        }
    }

    public void completeRental() {
        if(reservationStatus == ReservationStatus.IN_PROGRESS) {
            reservationStatus = ReservationStatus.COMPLETED;
            vehicle.setVehicleStatus(VehicleStatus.AVAILABLE);
            vehicle.removeReservation(this);
        }
    }

    public void cancelRental() {
        if(reservationStatus == ReservationStatus.PENDING || reservationStatus == ReservationStatus.BOOKED) {
            reservationStatus = ReservationStatus.CANCELLED;
            vehicle.setVehicleStatus(VehicleStatus.AVAILABLE);
            vehicle.removeReservation(this);
        }
    }

    public boolean overlaps(Date start, Date end) {

        return !(end.before(startDate) || start.after(endDate));
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public boolean processPayment() {
        return paymentStrategy.makePayment(amount);
    }
}
