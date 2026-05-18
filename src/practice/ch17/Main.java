package practice.ch17;

public class Main {
    public static void main(String[] args) {

        // 관찰 대상 생성
        NumberGenerator generator = new RandomNumberGenerator();

        // 관찰자 생성
        Observer observer = new DigitObserver();
        Observer observer2 = new GraphObserver();

        // 관찰자를 관찰대상에게 등록
        generator.addObserver(observer);
        generator.addObserver(observer2);

        // 관찰대상을 실행
        generator.execute(); 

    }

}
