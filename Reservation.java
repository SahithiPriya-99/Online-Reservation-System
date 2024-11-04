import java.util.Date;

class Reservation {
    private int reservationId;
    private String name;
    private int trainNumber;
    private String trainName;
    private String classType;
    private Date journeyDate;
    private String from;
    private String to;

    public Reservation(int reservationId, String name, int trainNumber, String trainName, 
                       String classType, Date journeyDate, String from, String to) {
        this.reservationId = reservationId;
        this.name = name;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.classType = classType;
        this.journeyDate = journeyDate;
        this.from = from;
        this.to = to;
    }

    public int getReservationId() {
        return reservationId;
    }

    @Override
    public String toString() {
        return "Reservation ID: " + reservationId + "\nName: " + name + 
               "\nTrain Number: " + trainNumber + "\nTrain Name: " + trainName +
               "\nClass Type: " + classType + "\nJourney Date: " + journeyDate +
               "\nFrom: " + from + " To: " + to;
    }
}
