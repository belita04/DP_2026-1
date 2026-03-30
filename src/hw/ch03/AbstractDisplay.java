package hw.ch03;

public abstract class AbstractDisplay {
    // 반복 횟수 저장 필드
    private int repeatCount;

    // 기본 생성자: 반복 횟수 기본값 5
    public AbstractDisplay() {
        this.repeatCount = 5;
    }

    // 반복 횟수를 직접 받는 생성자
    public AbstractDisplay(int repeatCount) {
        this.repeatCount = repeatCount;
    }

    // 하위 클래스가 구현할 추상 메소드
    protected abstract void open();
    public abstract void print();
    public abstract void close();

    // Template Method
    public final void display() {
        open();
        for (int i = 0; i < repeatCount; i++) {
            print();
        }
        close();
    }
}