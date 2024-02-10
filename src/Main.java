import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ParkingLotApp parkingLotApp = null;
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print("$ ");
            input = scanner.nextLine();
            String[] tokens = input.split(" ");

            switch (tokens[0]) {
                case "create_parking_lot":
                    int capacity = Integer.parseInt(tokens[1]);
                    parkingLotApp = new ParkingLotApp(capacity);
                    System.out.println("Created a parking lot with " + capacity + " slots");
                    break;
                case "park":
                    parkingLotApp.parkCar(tokens[1], tokens[2]);
                    break;
                case "leave":
                    parkingLotApp.leaveSlot(Integer.parseInt(tokens[1]));
                    break;
                case "status":
                    parkingLotApp.status();
                    break;
                case "registration_numbers_for_cars_with_colour":
                    parkingLotApp.registrationNumbersForCarsWithColour(tokens[1]);
                    break;
                case "slot_number_for_registration_number":
                    parkingLotApp.slotNumberForRegistrationNumber(tokens[1]);
                    break;
                case "slot_numbers_for_cars_with_colour":
                    parkingLotApp.slotNumbersForCarsWithColour(tokens[1]);
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Invalid command");
            }
        }
    }
}