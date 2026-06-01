package hw.ch20;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// 파일에서 큰 문자 데이터를 읽어들임
public class BigChar {
    // 문자의 이름
    private char charname;

    // 큰 문자를 표현하는 문자열('#' '.' '\n'으로 이루어진 열)
    // Flyweight 패턴에서 공유되는 내재 상태
    private String fontdata;

    // 색상을 원래대로 되돌리는 ANSI 코드
    private static final String RESET = "\u001B[0m";

    // 생성자
    public BigChar(char charname) {
        this.charname = charname;

        try {
            String filename = "big" + charname + ".txt";

            StringBuilder sb = new StringBuilder();

            for (String line : Files.readAllLines(Path.of(filename))) {
                sb.append(line);
                sb.append("\n");
            }

            this.fontdata = sb.toString();

        } catch (IOException e) {
            this.fontdata = charname + "?";
        }
    }

    // 기존 큰 문자 출력 메서드
    public void print() {
        System.out.print(fontdata);
    }

    // 색상 코드를 외재 상태로 받아 큰 문자를 출력하는 메서드
    public void print(String colorCode) {
        System.out.print(colorCode + fontdata + RESET);
    }
}