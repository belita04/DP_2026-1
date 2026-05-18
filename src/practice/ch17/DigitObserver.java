package practice.ch17;


// 관찰자
public class DigitObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) { // 통지받을 때 호출되는 메소드

        System.out.println("DigitObserver:" + generator.getNumber()); //관찰자가 하는 일
        try {
            Thread.sleep(1000); // 1초 대기한다./ 100 이면 0.1초 대기한다.
        } catch (InterruptedException e) {
        }
    }
}
