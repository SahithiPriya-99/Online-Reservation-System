import java.util.ArrayList;
import java.util.Date;

class ReservationSystem {
    private ArrayList<Reservation> reservations = new ArrayList<>();
    private int reservationCounter = 1;

    public void makeReservation(String name, int trainNumber, String trainName, 
                                String classType, Date journeyDate, String from, String to) {
        Reservation reservation = new Reservation(reservationCounter++, name, trainNumber, 
                                                  trainName, classType, journeyDate, from, to);
        reservations.add(reservation);
        System.out.println("Reservation Successful! Reservation ID: " + reservation.getReservationId());
    }

    public Reservation findReservationById(int reservationId) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationId() == reservationId) {
                return reservation;
            }
        }
        return null;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }
}
