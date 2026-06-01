package hw.ch20;

public class Main {
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";
    static final String MAGENTA = "\u001B[35m";
    static final String CYAN = "\u001B[36m";
    static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        // 실행 화면 첫 줄에 학번과 이름 출력
        System.out.println("학번: 20240761");
        System.out.println("이름: 이명진");
        System.out.println();

        String input;

        if (args.length == 0) {
            input = "1212123";
        } else {
            input = args[0];
        }

        // BigCharFactory를 이용한 인스턴스 공유 확인
        BigCharFactory factory = BigCharFactory.getInstance();

        BigChar char1 = factory.getBigChar('1');
        BigChar char2 = factory.getBigChar('1');

        if (char1 == char2) {
            System.out.println("char1과 char2는 같은 인스턴스입니다.");
        } else {
            System.out.println("char1과 char2는 다른 인스턴스입니다.");
        }

        System.out.println();

        // BigString 생성
        BigString bigString = new BigString(input);

        // 입력 문자열 1212123에 대응하는 색상 배열
        String[] colors = {
                RED,      // 1
                BLUE,     // 2
                GREEN,    // 1
                MAGENTA,  // 2
                CYAN,     // 1
                YELLOW,   // 2
                BLUE      // 3
        };

        System.out.println("색상이 적용된 큰 문자열 출력:");
        bigString.print(colors);

        System.out.print(RESET);
    }
}