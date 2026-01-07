package TrainTicketBookingSystem;

public class SleeperCoach extends Coach {

    SleeperCoach(int fare) {
        setFare(fare);
    }


    @Override
    public void cancelTicket() {
        totalFare = 0;
        System.out.println("Sleeper Ticket Cancelled. Refund issued.");
    }
}
