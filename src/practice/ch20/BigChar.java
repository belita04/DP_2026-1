package practice.ch20;

import java.io.IOException;
import java.nio.file.Files; // 파일에서 큰 문자 데이터를 읽어들임
import java.nio.file.Path;

// 파일에서 큰 문자 데이터를 읽어들임
public class BigChar {
    // 문자의 이름 
    private char charname;
    // 큰 문자를 표현하는 문자열('#' '.' '\n'으로 이루어진 열)
    private String fontdata;

    // 생성자 
    public BigChar(char charname) { // ex '3'
        this.charname = charname;
        try {
            String filename = "big" + charname + ".txt"; // ex "big3.txt"

            StringBuilder sb = new StringBuilder();

            for (String line: Files.readAllLines(Path.of(filename))) { // 각 줄을 읽어서 리스트가 만들어짐 , // 파일에서 큰 문자 데이터를 읽어들임, 파일 경로가 인자로 들어감. 파일의 내용을 전부 읽어들임 readAllLines() 메서드는 파일의 모든 줄을 읽어서 List<String> 형태로 반환한다. for 문으로 string 한줄씩 꺼내옴
                sb.append(line);
                sb.append("\n");
            }
            this.fontdata = sb.toString();
        } catch (IOException e) {
            this.fontdata = charname + "?";
        }
    }

    // 큰 문자를 표시한다
    public void print() {
        System.out.print(fontdata);
    }
}
