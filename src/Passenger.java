// 현재층수, 목표층수 랜덤으로 넣어주는
public class Passenger {
    private String id;
    private final int currentFloor;
    private final int targetFloor;
    private boolean isWaiting;
    private boolean isPassengerInElevator;

    public Passenger(String id) {
        this.id = id;
        this.currentFloor = (int)(Math.random() * 9) + 1;
        this.targetFloor = generateTargetFloor(this.currentFloor);
        this.isWaiting = true;
        this.isPassengerInElevator = false;
    }

    private int generateTargetFloor(int currentFloor) {
        int target;
        do {
            target = (int)(Math.random() * 9) + 1;
        } while (target == currentFloor);
        return target;
    }

    public int setTargetFloor() {
        return 1;
    }

    public String getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getTargetFloor() {
        return targetFloor;
    }

    public void setWaiting(boolean waiting) {
        isWaiting = waiting;
    }

    public boolean isWaiting() {
        return isWaiting;
    }
}
