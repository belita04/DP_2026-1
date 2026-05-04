package ch12.A2;

import java.util.ArrayList;
import java.util.List;

public class MultiStringDisplay extends Display {
    // 표시 문자열 저장 장소
    private List<String> body = new ArrayList<>();
    // 표시 문자열 최대 문자 수 
    private int columns = 0; // 현재 제일 긴 문자열의 길이

    // 문자열 추가 
    public void add(String msg) {
        body.add(msg);
        if (columns < msg.length()) { // 더 긴 문자열이 추가되면...
            // 최대 문자 수 갱신
            columns = msg.length();
        }
        updatePadding(); // -> 주석 처리시에 같은 열로 정렬되지 않고 문자열 바로 뒤에 장식이 붙는다.
        //-> 제일 긴 문자에 맞춰서 나머지 문자열의 오른쪽 끝에 공백을 채운다.
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
        return body.get(row);
    }

    // 표시 문자열 오른쪽 끝에 채울 공백을 필요에 따라 늘린다 (공백 채우기)
    private void updatePadding() {
        // 현재 추가된 모든 문자열에 대해서 for 문을 돌림. body.size()
        for (int row = 0; row < body.size(); row++) {
            String line = body.get(row);
            int padding = columns - line.length(); //13-3=10
            if (padding > 0) { // 현재 문자열이 제일 긴 문자열 보다 짧으면... 빈칸 채우기
                body.set(row, line + spaces(padding)); 
            }            
        }
    }

    // count 수만큼의 공백을 만든다 
    private String spaces(int count) {
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < count; i++) {
            spaces.append(' '); //count  만큼 공백이 생김
        }
        return spaces.toString();
    }
}
