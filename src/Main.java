import java.util.*;

public class Main {
    public static void main(String[] args) {
        while (true) {
            showMenu();  // 맨 하단에있는 showMenu 출력
            Scanner scanner = new Scanner(System.in); //스캐너 객체 생성
            String choice = scanner.nextLine();

            if (choice.equals("1")) {  // 입력값이 1과 같다면  BaseballGame 호출
                BaseballGame game = new BaseballGame();
                game.play();
            } else if (choice.equals("2")) {  // 입력값이 2와 같다면 "게임 기록 보기는 나중에 구현됩니다." 표시
                System.out.println("게임 기록 보기는 나중에 구현됩니다.");
            } else if (choice.equals("3")) { // 입력값이 3와 같다면 ""게임을 종료합니다." 표시 후 종료
                System.out.println("게임을 종료합니다.");
                break;
            } else {
                System.out.println("올바른 입력값이 아닙니다. 다시 입력해주세요."); // 1,2,3 외 다른 값 입력시 표시
            }
        }
    }
    // showMenu 값
    public static void showMenu() {
        System.out.println("숫자를 눌러 메뉴를 선택해주세요");
        System.out.println("1. 게임 시작하기");
        System.out.println("2. 게임 기록 보기");
        System.out.println("3. 종료하기");
    }
}