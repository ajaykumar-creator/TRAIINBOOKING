package TrainTicketBookingSystem;
public interface PassengerInterface {

    int getNumberOfSeats();
    void setNumberOfSeats(int n);

    String getCoachType();
    void setCoachType(String c);

    String getWantsFood();
    void setWantsFood(String f);

    int getFoodQty();
    void setFoodQty(int q);

    CoachInterface[] getCoach();
}
