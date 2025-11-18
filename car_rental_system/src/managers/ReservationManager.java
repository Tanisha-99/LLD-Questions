package managers;

import factory.Vehicle;
import utilityPackage.RentalStore;
import utilityPackage.Reservation;
import utilityPackage.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReservationManager {

    // price calculation should be done here
    // payment also
    private Map<String, Reservation> reservations;

    public ReservationManager() {
        reservations = new HashMap<>();
    }

    public Reservation createReservation(User user, Vehicle vehicle, RentalStore pickupStore, RentalStore dropStore, Date startDate, Date endDate) {
        Reservation reservation = new Reservation(user, vehicle, pickupStore, dropStore, startDate, endDate);
        reservations.put(reservation.getId(), reservation);
        reservation.getUser().addReservation(reservation);
        return reservation;
    }

    public void confirmReservation(String reservationId) {
        Reservation reservation = reservations.get(reservationId);
        if(reservation != null) {
            reservation.confirmReservation();
        }
    }

    public void startReservation(String reservationId) {
        Reservation reservation = reservations.get(reservationId);
        if(reservation != null) {
            reservation.startRental();
        }
    }

    public void completeReservation(String reservationId) {
        Reservation reservation = reservations.get(reservationId);
        if(reservation != null) {
            reservation.completeRental();
        }
    }

    public void cancelReservation(String reservationId) {
        Reservation reservation = reservations.get(reservationId);
        if(reservation != null) {
            reservation.cancelRental();
        }
    }

    public Reservation getReservation(String reservationId) {
        return reservations.get(reservationId);
    }
}
