
// 디스플레이 영역

class BaseballGameDisplay {
    public static void displayHint(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("아웃"); // 스트라이크가 0이고 볼이 0일땐 아웃을 출력
        } else {
            System.out.println(strike + "스트라이크 " + ball + "볼");
        }
    }
}
