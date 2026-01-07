package TrainTicketBookingSystem;
public interface CoachInterface {

    void calculateFare();


    int calculateFoodPrice(int qty);
    int calculateFoodPrice(int qty, int extraToppingsCharge);


    void cancelTicket();

    int getTotalFare();

    void setPassenger(PassengerInterface p);
    void setSeatingPattern(int[][] s);

    void displaySeating();
}
