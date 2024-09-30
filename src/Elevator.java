package src;

public class Elevator {
    private int currentFloor;
    private int passengerCount;
    private boolean isOpen;
    private boolean isEnter;

    public Elevator() {
        this.currentFloor = (int)(Math.random() * 9) + 1;
        this.passengerCount = 0;
        this.isOpen = false;
        this.isEnter = true;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public void setEnter(boolean enter) {
        isEnter = enter;
    }
}
