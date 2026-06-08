package practice.ch12;

// 중심 컴포넌트(문자열을 표시함)
public class StringDisplay extends Display {
    private String string; // 표시할 문자열 : "Hello, world."

    public StringDisplay(String string) {
        this.string = string;
    }

    @Override
    public int getColumns() { //string의 길이가 column의 개수 (띄어쓰기 포함)
        return string.length();
    }

    @Override
    public int getRows() {
        return 1; // 행수는 1
    }

    @Override
    public String getRowText(int row) {
        if (row != 0) {
            throw new IndexOutOfBoundsException();
        }
        return string;
    }
}

