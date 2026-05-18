package hw.ch17;

// 새로 추가한 관찰자
public class RangeObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) {
        int number = generator.getNumber();
        String range;

        if (number < 10) {
            range = "Low";
        } else if (number < 20) {
            range = "Mid";
        } else {
            range = "High";
        }

        System.out.println("RangeObserver: [" + range + "] " + number);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}