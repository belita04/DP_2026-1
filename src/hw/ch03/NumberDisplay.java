package hw.ch03;

public class NumberDisplay extends AbstractDisplay {
    private int number;

    // 기본 반복 횟수 5
    public NumberDisplay(int number) {
        super();
        this.number = number;
    }

    // 반복 횟수 직접 지정
    public NumberDisplay(int number, int repeatCount) {
        super(repeatCount);
        this.number = number;
    }

    @Override
    protected void open() {
        System.out.println("<<Number>>");
    }

    @Override
    public void print() {
        System.out.println(number);
    }

    @Override
    public void close() {
        System.out.println("<<Number>>");
    }
}