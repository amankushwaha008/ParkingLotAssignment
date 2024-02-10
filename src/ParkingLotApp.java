import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ParkingLotApp {
    private ParkingLot parkingLot;
    private Map<String, Car> cars;

    public ParkingLotApp(int capacity) {
        parkingLot = new ParkingLot(capacity);
        cars = new HashMap<>();
    }

    public void parkCar(String registrationNumber, String color) {
        Car car = new Car(registrationNumber, color);
        ParkingSlot slot = parkingLot.parkCar(car);
        if (slot != null) {
            cars.put(registrationNumber, car);
            System.out.println("Allocated slot number: " + slot.getSlotNumber());
        } else {
            System.out.println("Sorry, parking lot is full");
        }
    }

    public void leaveSlot(int slotNumber) {
        if (parkingLot.leaveSlot(slotNumber)) {
            System.out.println("Slot number " + slotNumber + " is free");
        } else {
            System.out.println("Invalid slot number");
        }
    }

    public void status() {
        System.out.println("Slot No. Registration No Colour");
        for (ParkingSlot slot : parkingLot.getSlots()) {
            Car car = slot.getCar();
            if (car != null) {
                System.out.println(slot.getSlotNumber() + " " + car.getRegistrationNumber() + " " + car.getColor());
            }
        }
    }

    public void registrationNumbersForCarsWithColour(String color) {
        List<String> registrationNumbers = new ArrayList<>();
        for (Car car : cars.values()) {
            if (car.getColor().equalsIgnoreCase(color)) {
                registrationNumbers.add(car.getRegistrationNumber());
            }
        }
        if (registrationNumbers.isEmpty()) {
            System.out.println("No cars found with color " + color);
        } else {
            System.out.println(String.join(", ", registrationNumbers));
        }
    }

    public void slotNumberForRegistrationNumber(String registrationNumber) {
        Car car = cars.get(registrationNumber);
        if (car != null) {
            for (ParkingSlot slot : parkingLot.getSlots()) {
                if (slot.getCar() != null && slot.getCar().getRegistrationNumber().equals(registrationNumber)) {
                    System.out.println("Slot number: " + slot.getSlotNumber());
                    return;
                }
            }
            System.out.println("Car with registration number " + registrationNumber + " not found");
        } else {
            System.out.println("Car with registration number " + registrationNumber + " not found");
        }
    }

    public void slotNumbersForCarsWithColour(String color) {
        List<Integer> slotNumbers = new ArrayList<>();
        for (ParkingSlot slot : parkingLot.getSlots()) {
            Car car = slot.getCar();
            if (car != null && car.getColor().equalsIgnoreCase(color)) {
                slotNumbers.add(slot.getSlotNumber());
            }
        }
        if (slotNumbers.isEmpty()) {
            System.out.println("No cars found with color " + color);
        } else {
            System.out.println("Slot numbers: " + slotNumbers);
        }
    }
}

