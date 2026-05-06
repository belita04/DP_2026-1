package hw.ch12;

// 장식자: 각 행 앞에 행 번호를 붙이는 클래스
public class NumberedBorder extends Border {
    public NumberedBorder(Display display) {
        super(display);
    }

    @Override
    public int getColumns() {
        return 4 + display.getColumns();
    }

    @Override
    public int getRows() {
        return display.getRows();
    }

    @Override
    public String getRowText(int row) {
        return String.format("%2d| %s", row + 1, display.getRowText(row));
    }
}