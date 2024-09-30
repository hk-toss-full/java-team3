import java.util.List;

public class ElevatorController {
    private Elevator elevator;
    Passenger[] passengers;

    public ElevatorController(Elevator elevator, Passenger[] passengers) {
        this.elevator = elevator;
        this.passengers = passengers;
    }

    public int getMinTime() {
        int currentFloor = elevator.getCurrentFloor();
        boolean[] visited = new boolean[passengers.length]; // 승객 수에 맞춰 크기 설정
        return dfs(currentFloor, 0, visited, passengers);
    }

    private int dfs(int currentFloor, int timeSpent, boolean[] visited, Passenger[] passengers) {
        boolean allDelivered = true;
        for (boolean visit : visited) {
            if (!visit) {
                allDelivered = false;
                break;
            }
        }

        if (allDelivered) {
            return timeSpent;
        }

        int minTime = Integer.MAX_VALUE;

        for (int i = 0; i < passengers.length; i++) { // 승객 수에 맞춰 반복
            if (!visited[i] && elevator.canTakePassenger()) {
                visited[i] = true;
                Passenger passenger = passengers[i];
                int timeToPickup = Math.abs(currentFloor - passenger.getCurrentFloor()) + 3; // 3 seconds for door open
                int timeToDeliver = Math.abs(passenger.getCurrentFloor() - passenger.getTargetFloor()) + 3; // 3 seconds for door open
                int totalTime = dfs(passenger.getTargetFloor(), timeSpent + timeToPickup + timeToDeliver, visited, passengers);
                minTime = Math.min(minTime, totalTime);
                visited[i] = false; // backtrack
            }
        }

        if (minTime == Integer.MAX_VALUE) {
            return timeSpent; // No more actions possible
        }

        return minTime;
    }

}