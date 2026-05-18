package hw.ch17;

public class Main {
    public static void main(String[] args) {
        System.out.println("20240761 이명진");

        // 관찰 대상 생성
        NumberGenerator generator = new EvenNumberGenerator(0, 30);

        // 관찰자 생성
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();
        Observer observer3 = new RangeObserver();

        // 관찰자를 관찰 대상에게 등록
        generator.addObserver(observer1);
        generator.addObserver(observer2);
        generator.addObserver(observer3);

        // 관찰 대상 실행
        generator.execute();
    }
}