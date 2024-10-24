import java.util.*;

class BaseballGame {
    private List<Integer> answer; // 정답을 저장할 리스트

    public BaseballGame() {
        answer = generateAnswer();
        System.out.println("< 게임을 시작합니다 >");
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("숫자를 입력하세요: ");
            String input = scanner.nextLine();

            if (!validateInput(input)) {
                System.out.println("올바르지 않은 입력값입니다.");
                continue;
            }

            int strike = countStrike(input);
            int ball = countBall(input);

            BaseballGameDisplay.displayHint(strike, ball); // 디스플레이힌트를 호출함

            if (strike == 3) {
                System.out.println("정답입니다!");  // 스트라이크 값이 3이면 정답입니다를 출력함
                break;
            }
        }
    }

    private List<Integer> generateAnswer() {
        List<Integer> numbers = new ArrayList<>();  //리스트생성
        for (int i = 1; i <= 9; i++) {     //1~9까지 리스트에 담음
            numbers.add(i);
        }
        Collections.shuffle(numbers);  // 숫자롤 랜덤하게 섞음
        return numbers.subList(0, 3); // 거기서 숫자룰 첫번째부터 세번째까지 가져옴
    }

    private boolean validateInput(String input) {
        if (input.length() != 3) {
            return false;
        }
        Set<Character> uniqueDigits = new HashSet<>(); // 해쉬셋으로 중복되지않게 생성
        for (char c : input.toCharArray()) {
            if (c < '1' || c > '9') {
                return false;  // c가 '1'부터 '9' 사이가 아니라면 잘못된 입력으로 간주
            }
            uniqueDigits.add(c);
        }
        return uniqueDigits.size() == 3;
    }
    //스트라이크 갯수를 계산하는 코드
    private int countStrike(String input) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (answer.get(i) == Character.getNumericValue(input.charAt(i))) {
                strike++;
            }
        }
        return strike;
    }
    //볼 갯수를 계산하는 코드
    private int countBall(String input) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            int userNum = Character.getNumericValue(input.charAt(i));
            if (answer.contains(userNum) && answer.get(i) != userNum) {
                ball++;
            }
        }
        return ball;
    }
}