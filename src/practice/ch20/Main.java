package practice.ch20;

public class Main {
    public static void main(String[] args) {
        BigChar char1 = new BigChar('1');
        char1.print();

        BigChar char2 = new BigChar('1');
        char2.print(); // 위와 내용은 같지만 서로 다른 인스턴스 => 메모리 낭비

        // BigCharFactory를 이용
        BigCharFactory factory = BigCharFactory.getInstance(); // singleton 패턴이므로 getInstance() 메서드를 통해서만 인스턴스를 얻을 수 있음

        BigChar char3 = factory.getBigChar('1');
        char3.print();

        BigChar char4 = factory.getBigChar('1');
        char4.print(); // char3과 내용도 같고 인스턴스도 같다 => 메모리 절약

        if(char3 == char4) {
            System.out.println("char3과 char4는 같은 인스턴스입니다.");
        } else {
            System.out.println("char3과 char4는 다른 인스턴스입니다.");
        }

        // BigString을 이용
        BigString bigString1 = new BigString("1212123");
        bigString1.print();
        
    }
  
}
