import java.util.Scanner;

class CancellationSystem {
    private ReservationSystem reservationSystem;

    public CancellationSystem(ReservationSystem reservationSystem) {
        this.reservationSystem = reservationSystem;
    }

    public void cancelReservation(int reservationId) {
        Reservation reservation = reservationSystem.findReservationById(reservationId);
        if (reservation != null) {
            System.out.println("Reservation Found:\n" + reservation);
            System.out.println("Confirm cancellation? (Y/N)");
            Scanner scanner = new Scanner(System.in);
            String confirm = scanner.next();
            if ("Y".equalsIgnoreCase(confirm)) {
                reservationSystem.getReservations().remove(reservation);
                System.out.println("Reservation canceled successfully.");
            } else {
                System.out.println("Cancellation aborted.");
            }
        } else {
            System.out.println("Reservation not found.");
        }
    }
}
