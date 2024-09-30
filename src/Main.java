package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Elevator elevator = new Elevator();
        Passenger passenger1 = new Passenger();
        Passenger passenger2 = new Passenger();
        Passenger passenger3 = new Passenger();
        Passenger passenger4 = new Passenger();
        Passenger passenger5 = new Passenger();

        while (true) {
            System.out.print("<1. 문열기, 2. 대기자 보기, 3. 이동하기> - 현재 층수 ");
            System.out.print(elevator.getCurrentFloor() + ", 총 정원 수 (");
            System.out.println(elevator.getPassengerCount() + "/2)");

            String inputData = sc.nextLine();
            if (inputData.equals("1")) {
                System.out.println("문열기");
                System.out.println();
            }
            if (inputData.equals("2")) {
                System.out.println("대기자 보기");
                System.out.println("1번째 대기자 (" + passenger1.getCurrentFloor() + "->" + passenger1.getTargetFloor() + ")");
                System.out.println("2번째 대기자 (" + passenger2.getCurrentFloor() + "->" + passenger2.getTargetFloor() + ")");
                System.out.println("3번째 대기자 (" + passenger3.getCurrentFloor() + "->" + passenger3.getTargetFloor() + ")");
                System.out.println("4번째 대기자 (" + passenger4.getCurrentFloor() + "->" + passenger4.getTargetFloor() + ")");
                System.out.println("5번째 대기자 (" + passenger5.getCurrentFloor() + "->" + passenger5.getTargetFloor() + ")");
            }
            if (inputData.equals("3")) {
                System.out.println("<UP, DOWN>");
                if (inputData.equalsIgnoreCase("UP")) {
                    System.out.println("올라갑니다.");
                }
                if (inputData.equalsIgnoreCase("DOWN")) {
                    System.out.println("내려갑니다.");
                }
            }
        }
    }
}
