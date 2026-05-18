package practice.ch17;

import java.util.Random;


// 관찰 대상
public class RandomNumberGenerator extends NumberGenerator {
    private Random random = new Random(); 	// 난수 생성기 
    private int number;                   		// 현재 수 (상태)

    // 수를 취득한다 
    @Override
    public int getNumber() {
        return number;
    }

    // 수를 생성한다 
    @Override
    public void execute() {
        for (int i = 0; i < 20; i++) {
            number = random.nextInt(50); // 0부터 49까지의 난수를 생성한다.
            notifyObservers(); // 관찰자들에게 통지한다. 20번.
        }
    }
}
