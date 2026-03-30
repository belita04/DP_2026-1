package hw.ch03;

public class CharDisplay extends AbstractDisplay {
    private char ch;

    // 기본 반복 횟수 5
    public CharDisplay(char ch) {
        super();
        this.ch = ch;
    }

    // 반복 횟수 직접 지정
    public CharDisplay(char ch, int repeatCount) {
        super(repeatCount);
        this.ch = ch;
    }

    @Override
    protected void open() {
        System.out.print("<<");
    }

    @Override
    public void print() {
        System.out.print(ch);
    }

    @Override
    public void close() {
        System.out.println(">>");
    }
}