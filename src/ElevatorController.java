import java.util.List;

public class ElevatorController {
    private Elevator elevator;

    public ElevatorController(Elevator elevator) {
        this.elevator = elevator;
    }

    public int getMinTime() {
        List<Passenger> passengers = List.of(elevator.getPassengers());
        int currentFloor = elevator.getCurrentFloor();
        boolean[] visited = new boolean[passengers.size()]; // 승객 수에 맞춰 크기 설정
        return dfs(currentFloor, 0, visited, passengers);
    }

    private int dfs(int currentFloor, int timeSpent, boolean[] visited, List<Passenger> passengers) {
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

        for (int i = 0; i < passengers.size(); i++) { // 승객 수에 맞춰 반복
            if (!visited[i] && elevator.canTakePassenger()) {
                visited[i] = true;
                Passenger passenger = passengers.get(i);
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