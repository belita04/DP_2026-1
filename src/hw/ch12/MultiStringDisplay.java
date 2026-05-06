package hw.ch12;

import java.util.ArrayList;
import java.util.List;

// 중심 컴포넌트: 여러 줄 문자열을 표시하는 클래스
public class MultiStringDisplay extends Display {
    private List<String> body = new ArrayList<>();
    private int columns = 0;

    // 문자열을 추가한다
    public void add(String msg) {
        body.add(msg);
        updatePadding();
    }

    // 가장 긴 문자열 길이에 맞춰 짧은 문자열 뒤에 공백을 붙인다
    private void updatePadding() {
        int max = 0;

        for (String line : body) {
            if (line.length() > max) {
                max = line.length();
            }
        }

        columns = max;

        for (int i = 0; i < body.size(); i++) {
            String line = body.get(i);
            StringBuilder sb = new StringBuilder(line);

            while (sb.length() < columns) {
                sb.append(' ');
            }

            body.set(i, sb.toString());
        }
    }

    @Override
    public int getColumns() {
        return columns;
    }

    @Override
    public int getRows() {
        return body.size();
    }

    @Override
    public String getRowText(int row) {
        if (row < 0 || row >= body.size()) {
            throw new IndexOutOfBoundsException();
        }
        return body.get(row);
    }
}