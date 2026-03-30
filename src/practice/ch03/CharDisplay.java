package practice.ch03;

public class CharDisplay extends AbstractDisplay {
    private char ch; // 표시해야 하는 문자 

    // 생성자 
    public CharDisplay(char ch) {
        this.ch = ch;
    }

    @Override
    public void open() {
        // 시작 문자열 "<<"를 표시한다
        System.out.print("<<");
    }

    @Override //컴파일러가 부모쪽에 있는 메소드와 오버라이드한 메소드가 일치하는지 체크해줌, 일치하지 않으면 에러를 발생시킴
    public void print() {
        // 필드에 기억해 둔 문자를 1회 표시한다 
        System.out.print(ch);
    }

    @Override
    public void close() {
        // 종료 문자열 ">>"를 표시한다 
        System.out.println(">>");
    }
}
