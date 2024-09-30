public class Elevator {
    private final Passenger[] passengers;



    private Passenger[] allPassengers;
    private int currentFloor;


    private int initFloor;
    private int passengerCount;
    private int totalTime;
    private boolean isOpen;
    private boolean isEnter;

    public Elevator() {
        this.passengers = new Passenger[2];
        this.initFloor = (int)(Math.random() * 10) + 1;
        this.currentFloor = this.initFloor;
        this.passengerCount = 0;
        this.totalTime = 0;
        this.isOpen = false;
        this.isEnter = true;
    }

    public int getInitFloor() {
        return initFloor;
    }

    public void setInitFloor(int initFloor) {
        this.initFloor = initFloor;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void upCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor + 1;
        totalTime+=1;
    }

    public void downCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor - 1;
        totalTime+=1;
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

    public void addPassenger(Passenger passenger) {
        for (int i = 0; i < 2; i++) {
            if (passengers[i] == null) {
                passengers[i] = passenger;
                passengers[i].setWaiting(false);
                System.out.println("승객이 추가되었습니다: " + passenger);
                passengerCount++;
                return;
            }
        }
        System.out.println("정원 초과.");
    }

    public void removePassenger(Passenger passenger) {
        for (int i = 0; i < 2; i++) {
            if (passenger.equals(passengers[i])) {
                passengers[i] = null;
                System.out.println("승객이 내렸습니다: " + passenger);
                passengerCount--;
                return;
            }
        }
        System.out.println("해당 승객은 엘리베이터에 없습니다.");
    }

    public Passenger[] getPassengers() {
        return passengers;
    }

    public boolean canTakePassenger() {
        return passengerCount < 2;
    }
}
