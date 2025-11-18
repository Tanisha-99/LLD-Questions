package managers;

import factory.Vehicle;
import utilityPackage.RentalStore;
import utilityPackage.Reservation;
import utilityPackage.User;

import java.util.*;

public class RentalSystem {
    private static RentalStore rentalStore;
    private List<RentalStore> rentalStores;
    private ReservationManager reservationManager;
    private PaymentProcessor paymentProcessor;
    private Map<String, User> users; //Id -> User

    private RentalSystem() {
        this.rentalStores = new ArrayList<>();
        this.reservationManager = new ReservationManager();
        this.paymentProcessor = new PaymentProcessor();
        this.users = new HashMap<>();
    }

    public static synchronized RentalStore getRentalStore() {
        if(rentalStore == null) {
            rentalStore = new RentalStore();
        }

        return rentalStore;
    }

    public void addStore(RentalStore store) {
        rentalStores.add(store);
    }

    public RentalStore getRentalStore(String id) {
        for(RentalStore rs : rentalStores) {
            if(rs.getId().equals(id)) {
                return rs;
            }
        }

        return null;
    }

    public List<RentalStore> getRentalStores() {
        return rentalStores;
    }

    public User getUser(String id) {
        return users.get(id);
    }

    public Reservation createReservation(String userId, String vehicleId, String pickupStoreId, String dropStoreId, Date startDate, Date endDate) {
        User user = users.get(userId);
        RentalStore pickupRentalStore = getRentalStore(pickupStoreId);
        RentalStore dropRentalStore = getRentalStore(dropStoreId);

        Vehicle vehicle = (pickupRentalStore != null) ? pickupRentalStore.getVehicle(vehicleId) : null;

        if(user != null && vehicle != null && pickupRentalStore != null && dropRentalStore != null && vehicle.isAvailable(startDate, endDate)) {
            return reservationManager.createReservation(user, vehicle, pickupRentalStore, dropRentalStore, startDate, endDate);
        }

        return null;
    }

    public boolean processPayment(String reservationId) {
        Reservation reservation = reservationManager.getReservation(reservationId);

        boolean paymentCompleted = reservation.processPayment();
        if(paymentCompleted) {
            reservationManager.confirmReservation(reservationId);
            return true;
        }

        return false;
    }

    public void startRental(String reservationId) {
        reservationManager.startReservation(reservationId);
    }

    public void completeRental(String reservationId) {
        reservationManager.completeReservation(reservationId);
    }

    public void cancelReservation(String reservationId) {
        reservationManager.cancelReservation(reservationId);
    }
}
