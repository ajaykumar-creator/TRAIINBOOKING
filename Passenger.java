package TrainTicketBookingSystem;
public class Passenger implements PassengerInterface {

    private int numberOfSeats;
    private int foodQty;
    private String coachType;
    private String wantsFood;

    private CoachInterface[] coach = new CoachInterface[2];

    public int getNumberOfSeats() {
        return numberOfSeats;
    }
    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getCoachType() {
        return coachType;
    }
    public void setCoachType(String coachType) {
        this.coachType = coachType;
    }

    public String getWantsFood() {
        return wantsFood;
    }
    public void setWantsFood(String wantsFood) {
        this.wantsFood = wantsFood;
    }

    public int getFoodQty() {
        return foodQty;
    }
    public void setFoodQty(int foodQty) {
        this.foodQty = foodQty;
    }

    public CoachInterface[] getCoach() {
        return coach;
    }
}
