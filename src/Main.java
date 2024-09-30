import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Elevator elevator = new Elevator();
        ElevatorGame elevatorGame = new ElevatorGame(elevator);

        elevatorGame.startGame();
    }
}
