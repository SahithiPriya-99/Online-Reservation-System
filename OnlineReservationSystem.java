import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class OnlineReservationSystem {
    public static void main(String[] args) {
        Login login = new Login();
        ReservationSystem reservationSystem = new ReservationSystem();
        CancellationSystem cancellationSystem = new CancellationSystem(reservationSystem);
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Username:");
        String username = scanner.next();
        System.out.println("Enter Password:");
        String password = scanner.next();

        if (login.authenticate(username, password)) {
            System.out.println("Login Successful!");

            boolean exit = false;
            while (!exit) {
                System.out.println("\nChoose an Option:");
                System.out.println("1) Make a Reservation");
                System.out.println("2) View Reservation by ID");
                System.out.println("3) View All Reservations");
                System.out.println("4) Cancel Reservation");
                System.out.println("5) Exit");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter Passenger Name:");
                        String name = scanner.next();
                        System.out.println("Enter Train Number:");
                        int trainNumber = scanner.nextInt();
                        System.out.println("Enter Train Name:");
                        String trainName = scanner.next();
                        System.out.println("Enter Class Type:");
                        String classType = scanner.next();
                        System.out.println("Enter Journey Date (e.g., 2024-12-31):");
                        Date journeyDate = new Date(); 
                        System.out.println("Enter From:");
                        String from = scanner.next();
                        System.out.println("Enter To:");
                        String to = scanner.next();

                        reservationSystem.makeReservation(name, trainNumber, trainName, 
                                                          classType, journeyDate, from, to);
                        break;

                    case 2:
                        System.out.println("Enter Reservation ID:");
                        int reservationId = scanner.nextInt();
                        Reservation reservation = reservationSystem.findReservationById(reservationId);
                        if (reservation != null) {
                            System.out.println("Reservation Found:\n" + reservation);
                        } else {
                            System.out.println("No reservation found with ID " + reservationId);
                        }
                        break;

                    case 3:
                        ArrayList<Reservation> reservations = reservationSystem.getReservations();
                        if (reservations.isEmpty()) {
                            System.out.println("No reservations found.");
                        } else {
                            System.out.println("All Reservations:");
                            for (Reservation res : reservations) {
                                System.out.println(res);
                                System.out.println("---------------");
                            }
                        }
                        break;

                    case 4:
                        System.out.println("Enter Reservation ID to cancel:");
                        int cancelId = scanner.nextInt();
                        cancellationSystem.cancelReservation(cancelId);
                        break;

                    case 5:
                        exit = true;
                        System.out.println("Exiting the system. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            }
        } else {
            System.out.println("Invalid login credentials.");
        }
        scanner.close();
    }
}
