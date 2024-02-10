public class ParkingSlot {
    private int slotNumber;
    private Car car;

    public ParkingSlot(int slotNumber) {
        this.slotNumber = slotNumber;
        this.car = null;
    }
    public void parkCar(Car car) {
        this.car = car;
    }

    public void removeCar() {
        this.car = null;
    }

    public int getSlotNumber() {
        return slotNumber;
    }
    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }
}

