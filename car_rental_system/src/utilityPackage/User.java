package utilityPackage;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String id;
    private String name;
    private String email;
    private List<Reservation> reservations;

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.reservations = new ArrayList<Reservation>();
    }

    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }

    public void deleteReservation(Reservation reservation) {
        this.reservations.remove(reservation);
    }
}
