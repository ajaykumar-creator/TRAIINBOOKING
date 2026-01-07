package TrainTicketBookingSystem;
public abstract class Coach implements CoachInterface {

    private int fare;
    protected int totalFare;
    protected PassengerInterface passenger;
    private int[][] seatingPattern;

    public void calculateFare() {
        fare = passenger.getNumberOfSeats() * fare;
        totalFare = fare;
        System.out.println("Ticket Fare: " + fare);
    }


    public int calculateFoodPrice(int qty) {
        return qty * 100;
    }

    public int calculateFoodPrice(int qty, int extraCharge) {
        return (qty * 100) + extraCharge;
    }


    public void cancelTicket() {
        System.out.println("Cancellation not allowed for this coach");
    }

    public int getTotalFare() {
        return totalFare;
    }

    public void setFare(int f) { this.fare = f; }

    public void setPassenger(PassengerInterface p) { this.passenger = p; }

    public void setSeatingPattern(int[][] s) { this.seatingPattern = s; }

    public void displaySeating() {
        for(int i=0;i<seatingPattern.length;i++){
            if(i!=0) System.out.print((char)(65+i-1)+" ");
            for(int j=0;j<seatingPattern[i].length;j++){
                if(i==0 && j==0) System.out.print("  ");
                System.out.print(seatingPattern[i][j]+" ");
                if (j == 2) System.out.print("  ");
            }
            System.out.println();
        }
    }
}
