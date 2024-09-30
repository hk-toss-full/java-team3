import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Elevator elevator = new Elevator();
        ElevatorGame elevatorGame = new ElevatorGame(elevator);

//        while(true) {
//            boolean isEnd = elevatorGame.startGame();
//            System.out.println("게임 다시 ㄱ?");
//
//            Scanner sc = new Scanner(System.in);
//            String isRestart = sc.nextLine();
//            if(isRestart) initElevatorGame();
//            else    break;
//
//
//        }
    }
}
