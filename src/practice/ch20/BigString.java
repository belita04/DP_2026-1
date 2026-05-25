package practice.ch20;

public class BigString {
    // '큰 문자'의 배열
    private BigChar[] bigchars;

    // 생성자 
    public BigString(String string) {
        BigCharFactory factory = BigCharFactory.getInstance();

        bigchars = new BigChar[string.length()];

        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i] = factory.getBigChar(string.charAt(i)); // 문자열 중에서 i 번째 문자
        }
    }

    // 표시
    public void print() {
        for (BigChar bc: bigchars) {
            bc.print();
        }
    }
}
