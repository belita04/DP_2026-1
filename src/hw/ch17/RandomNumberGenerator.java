package hw.ch17;

import java.util.Random;

// 관찰 대상
public class RandomNumberGenerator extends NumberGenerator {
    private Random random = new Random(); // 난수 생성기
    private int number;                   // 현재 수

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        for (int i = 0; i < 20; i++) {
            number = random.nextInt(50); // 0부터 49까지의 난수 생성
            notifyObservers();           // 관찰자들에게 통지
        }
    }
}