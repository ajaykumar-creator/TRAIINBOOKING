package TrainTicketBookingSystem;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        PassengerInterface p1 = new Passenger();
        System.out.println("===== PASSENGER 1 =====");
        System.out.println("Enter number of seats:");
        BigInteger seats1 = new BigInteger(sc.nextLine());
        p1.setNumberOfSeats(seats1.intValue());

        System.out.println("Enter Coach Type (AC / SLEEPER):");
        p1.setCoachType(sc.nextLine());

        System.out.println("Want Food? (YES/NO)");
        String food1 = sc.nextLine();
        p1.setWantsFood(food1);
        BigInteger foodQty1;

        if (food1.equals("YES")) {
            System.out.println("Enter food quantity:");
            foodQty1 = new BigInteger(sc.nextLine());
        } else {
            foodQty1 = new BigInteger("0");
        }
        p1.setFoodQty(foodQty1.intValue());


        if (p1.getCoachType().equals("AC")) {
            int[][] acSeats = new int[6][5];
            acSeats[0] = new int[]{1, 2, 3, 4, 5};
            System.out.println("AC Coach Seating Layout:");
            for (int i = 0; i < acSeats.length; i++) {
                if (i != 0) System.out.print((char) (65 + i - 1) + " ");
                for (int j = 0; j < acSeats[i].length; j++) {
                    if (i == 0 && j == 0) System.out.print("  ");
                    System.out.print(acSeats[i][j] + " ");
                    if (j == 2) System.out.print("  ");
                }
                System.out.println();
            }

            CoachInterface c1 = new ACCoach(700);

            for (int i = 0; i < p1.getNumberOfSeats(); i++) {
                boolean valid = false;
                while (!valid) {
                    try {
                        System.out.println("Enter seat (Eg: A1):");
                        String seat = sc.nextLine();
                        char[] chars = seat.toCharArray();
                        int row = chars[0] - 65;
                        int col = Character.getNumericValue(seat.charAt(1)) - 1;
                        if (acSeats[row + 1][col] == 1) {
                            System.out.println("Seat already booked");
                        } else {
                            acSeats[row + 1][col] = 1;
                            valid = true;
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid seat");
                    }
                }
            }

            c1.setPassenger(p1);
            c1.setSeatingPattern(acSeats);
            p1.getCoach()[0] = c1;

            c1.calculateFare();

            if (p1.getWantsFood().equals("YES")) {
                int foodAmount1;
                if (p1.getFoodQty() > 2) {
                    foodAmount1 = c1.calculateFoodPrice(p1.getFoodQty(), 50); // overloaded
                } else {
                    foodAmount1 = c1.calculateFoodPrice(p1.getFoodQty());
                }
                System.out.println("Food Amount: " + foodAmount1);
            }

            System.out.println("Cancel Ticket? (YES/NO)");
            if (sc.nextLine().equals("YES")) {
                c1.cancelTicket(); // overridden only in Sleeper
            }

            System.out.println("Final Amount: " + c1.getTotalFare());
            c1.displaySeating();

        } else {
            int[][] sleeperSeats = new int[6][5];
            sleeperSeats[0] = new int[]{1, 2, 3, 4, 5};
            System.out.println("Sleeper Coach Seating Layout:");
            for (int i = 0; i < sleeperSeats.length; i++) {
                if (i != 0) System.out.print((char) (65 + i - 1) + " ");
                for (int j = 0; j < sleeperSeats[i].length; j++) {
                    if (i == 0 && j == 0) System.out.print("  ");
                    System.out.print(sleeperSeats[i][j] + " ");
                    if (j == 2) System.out.print("  ");
                }
                System.out.println();
            }

            CoachInterface c1 = new SleeperCoach(400);
            for (int i = 0; i < p1.getNumberOfSeats(); i++) {
                boolean valid = false;
                while (!valid) {
                    try {
                        System.out.println("Enter seat (Eg: A1):");
                        String seat = sc.nextLine();
                        int row = seat.charAt(0) - 65;
                        int col = Character.getNumericValue(seat.charAt(1)) - 1;
                        if (sleeperSeats[row + 1][col] == 1) {
                            System.out.println("Seat already booked");
                        } else {
                            sleeperSeats[row + 1][col] = 1;
                            valid = true;
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid seat");
                    }
                }
            }

            c1.setPassenger(p1);
            c1.setSeatingPattern(sleeperSeats);
            p1.getCoach()[0] = c1;

            c1.calculateFare();

            if (p1.getWantsFood().equals("YES")) {
                int foodAmount1;
                if (p1.getFoodQty() > 2) {
                    foodAmount1 = c1.calculateFoodPrice(p1.getFoodQty(), 50); // overloaded
                } else {
                    foodAmount1 = c1.calculateFoodPrice(p1.getFoodQty());
                }
                System.out.println("Food Amount: " + foodAmount1);
            }

            System.out.println("Cancel Ticket? (YES/NO)");
            if (sc.nextLine().equals("YES")) {
                c1.cancelTicket(); // overridden only in Sleeper
            }

            System.out.println("Final Amount: " + c1.getTotalFare());
            c1.displaySeating();
        }


        PassengerInterface p2 = new Passenger();
        System.out.println("===== PASSENGER 2 =====");
        System.out.println("Enter number of seats:");
        BigInteger seats2 = new BigInteger(sc.nextLine());
        p2.setNumberOfSeats(seats2.intValue());

        System.out.println("Enter Coach Type (AC / SLEEPER):");
        p2.setCoachType(sc.nextLine());

        System.out.println("Want Food? (YES/NO)");
        String food2 = sc.nextLine();
        p2.setWantsFood(food2);
        BigInteger foodQty2;

        if (food2.equals("YES")) {
            System.out.println("Enter food quantity:");

            foodQty2 = new BigInteger(sc.nextLine());
        } else {
            foodQty2 = new BigInteger("0");
        }
        p2.setFoodQty(foodQty2.intValue());

        if (p2.getCoachType().equals("AC")) {
            int[][] acSeats2 = new int[6][5];
            acSeats2[0] = new int[]{1, 2, 3, 4, 5};
            System.out.println("AC Coach Seating Layout:");
            for (int i = 0; i < acSeats2.length; i++) {
                if (i != 0) System.out.print((char) (65 + i - 1) + " ");
                for (int j = 0; j < acSeats2[i].length; j++) {
                    if (i == 0 && j == 0) System.out.print("  ");
                    System.out.print(acSeats2[i][j] + " ");
                    if (j == 2) System.out.print("  ");
                }
                System.out.println();
            }

            CoachInterface c2 = new ACCoach(700);
            for (int i = 0; i < p2.getNumberOfSeats(); i++) {
                boolean valid = false;
                while (!valid) {
                    try {
                        System.out.println("Enter seat (Eg: A1):");
                        String seat = sc.nextLine();
                        int row = seat.charAt(0) - 65;
                        int col = Character.getNumericValue(seat.charAt(1)) - 1;
                        if (acSeats2[row + 1][col] == 1) {
                            System.out.println("Seat already booked");
                        } else {
                            acSeats2[row + 1][col] = 1;
                            valid = true;
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid seat");
                    }
                }
            }

            c2.setPassenger(p2);
            c2.setSeatingPattern(acSeats2);
            p2.getCoach()[0] = c2;

            c2.calculateFare();
            if (p2.getWantsFood().equals("YES")) {
                int foodAmount2 = c2.calculateFoodPrice(p2.getFoodQty(), 50);
                System.out.println("Food Amount (With Extra Toppings): " + foodAmount2);
            }
            System.out.println("Cancel Ticket? (YES/NO)");
            if (sc.nextLine().equals("YES")) {
                c2.cancelTicket();
            }
            System.out.println("Final Amount: " + c2.getTotalFare());
            c2.displaySeating();

        } else {
            int[][] sleeperSeats2 = new int[6][5];
            sleeperSeats2[0] = new int[]{1, 2, 3, 4, 5};
            System.out.println("Sleeper Coach Seating Layout:");
            for (int i = 0; i < sleeperSeats2.length; i++) {
                if (i != 0) System.out.print((char) (65 + i - 1) + " ");
                for (int j = 0; j < sleeperSeats2[i].length; j++) {
                    if (i == 0 && j == 0) System.out.print("  ");
                    System.out.print(sleeperSeats2[i][j] + " ");
                    if (j == 2) System.out.print("  ");
                }
                System.out.println();
            }

            CoachInterface c2 = new SleeperCoach(400);
            for (int i = 0; i < p2.getNumberOfSeats(); i++) {
                boolean valid = false;
                while (!valid) {
                    try {
                        System.out.println("Enter seat (Eg: A1):");
                        String seat = sc.nextLine();
                        int row = seat.charAt(0) - 65;
                        int col = Character.getNumericValue(seat.charAt(1)) - 1;
                        if (sleeperSeats2[row + 1][col] == 1) {
                            System.out.println("Seat already booked");
                        } else {
                            sleeperSeats2[row + 1][col] = 1;
                            valid = true;
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid seat");
                    }
                }
            }

            c2.setPassenger(p2);
            c2.setSeatingPattern(sleeperSeats2);
            p2.getCoach()[0] = c2;

            c2.calculateFare();
            if (p2.getWantsFood().equals("YES")) {
                int foodAmount2 = c2.calculateFoodPrice(p2.getFoodQty(), 50);
                System.out.println("Food Amount (With Extra Toppings): " + foodAmount2);
            }
            System.out.println("Cancel Ticket? (YES/NO)");
            if (sc.nextLine().equals("YES")) {
                c2.cancelTicket();
            }
            System.out.println("Final Amount: " + c2.getTotalFare());
            c2.displaySeating();
        }

    }
}
