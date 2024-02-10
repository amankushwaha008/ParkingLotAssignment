import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    public int getCapacity() {
        return capacity;
    }


    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public List<ParkingSlot> getSlots() {
        return slots;
    }


    public void setSlots(List<ParkingSlot> slots) {
        this.slots = slots;
    }

    private int capacity;
    private List<ParkingSlot> slots;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        slots = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            slots.add(new ParkingSlot(i + 1));
        }
    }


    public ParkingSlot parkCar(Car car) {
        for (ParkingSlot slot : slots) {
            if (slot.getCar() == null) {
                slot.parkCar(car);
                return slot;
            }
        }
        return null;
    }

    public boolean leaveSlot(int slotNumber) {
        if (slotNumber < 1 || slotNumber > capacity) {
            return false;
        }
        slots.get(slotNumber - 1).removeCar();
        return true;
    }
}

