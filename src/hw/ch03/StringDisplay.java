package hw.ch03;

public class StringDisplay extends AbstractDisplay {
    private String string;
    private int width;

    // 기본 반복 횟수 5
    public StringDisplay(String string) {
        super();
        this.string = string;
        this.width = string.length();
    }

    // 반복 횟수 직접 지정
    public StringDisplay(String string, int repeatCount) {
        super(repeatCount);
        this.string = string;
        this.width = string.length();
    }

    @Override
    protected void open() {
        printLine();
    }

    @Override
    public void print() {
        System.out.println("|" + string + "|");
    }

    @Override
    public void close() {
        printLine();
    }

    private void printLine() {
        System.out.print("+");
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}