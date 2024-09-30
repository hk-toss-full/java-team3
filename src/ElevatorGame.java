import java.util.Scanner;

public class ElevatorGame {
    public ElevatorGame(Elevator elevator) {
        this.elevator = elevator;
    }

    Elevator elevator;
    Passenger passenger1 = new Passenger();
    Passenger passenger2 = new Passenger();
    Passenger passenger3 = new Passenger();
    Passenger passenger4 = new Passenger();
    Passenger passenger5 = new Passenger();

    Passenger[] passengers = {passenger1, passenger2, passenger3, passenger4, passenger5};

    public void startGame() {
        while(true) {
            System.out.print("<1. 문열기, 2. 대기자 보기, 3. 이동하기> - 현재 층수 ");
            System.out.print(elevator.getCurrentFloor() + ", 총 정원 수 (");
            System.out.println(elevator.getPassengerCount() + "/2)");

            Scanner sc = new Scanner(System.in);
            String inputData = sc.nextLine();
            if (inputData.equals("1")) {
                if (elevator.getPassengerCount() == 2) {
                    System.out.println("<정원이 꽉 찼습니다. 더 태울 수 없습니다. 3초가 흘러갑니다.>");
                }
    //                if () {     // 누가 기다리고 있는지 어떻게 알지? 일단 "타고 내리는 사람 없는데 문 연 경우"
    //                    System.out.println("<현재 층에서 타거나 내리는 대기자가 없습니다. 3초가 흘러갑니다.>");
    //                }
                System.out.println("문열기");
                System.out.println();
            }

            if (inputData.equals("2")) {
                System.out.println("대기자 보기");
                for (int i = 0; i < passengers.length; i++) {
                    if (passengers[i].isWaiting()) {
                        System.out.println((i + 1) + "번 대기자 (" + passengers[i].getCurrentFloor() + "->" + passengers[i].getTargetFloor() + ")");
                    }
                }
            }
            if (inputData.equals("3")) {
                System.out.println("<UP, DOWN>");
                inputData = sc.nextLine();
                if (inputData.equalsIgnoreCase("UP")) {
                    if (elevator.getCurrentFloor() == 10) {
                        System.out.println("<현재 층에서 올라갈 수 없습니다. 시간은 흐르지 않습니다.>");
                    } else {
                        elevator.upCurrentFloor(elevator.getCurrentFloor());
                        System.out.println("올라갑니다.");
                    }
                }
                if (inputData.equalsIgnoreCase("DOWN")) {
                    if (elevator.getCurrentFloor() == 1) {
                        System.out.println("<현재 층에서 내려갈 수 없습니다. 시간은 흐르지 않습니다.>");
                    } else {
                        elevator.downCurrentFloor(elevator.getCurrentFloor());
                        System.out.println("내려갑니다.");
                    }
                }
            }
            int check = 0;
            for (Passenger passenger : passengers) {
                if (!passenger.isWaiting()) {
                    check++;
                }
            }
            if (check == 5) {
                ElevatorController controller = new ElevatorController(elevator, passengers);
                int minTime = controller.getMinTime();

                System.out.println("게임을 종료합니다.");
                System.out.println("-------------------------END-------------------------\n");
                System.out.println("1. 걸린시간: ");
                System.out.println("2. 최단시간: "+ minTime + "s");


                System.out.println("더 좋은 기록을 위해 한 번더 하시겠습니까? (YES/NO)");
                String isRestart = sc.nextLine();
                if(isRestart.equalsIgnoreCase("YES")) init();
                else break;
            }
        }
    }

    public void init() {
        for(int i = 0; i < passengers.length; i++) {
            passengers[i].setWaiting(false);
        }
        elevator.setInitFloor(elevator.getInitFloor());
    }
}
