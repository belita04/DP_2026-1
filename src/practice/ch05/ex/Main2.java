package practice.ch05.ex;

public class Main2 {
    public static void main(String[] args) {
        // 스레드 객체 생성
        Main t1 = new Main("Thread-A");
        Main t2 = new Main("Thread-B");

        // 스레드에 시작해라 지시
        t1.start(); // 스레드가 해야할 일을 작성한 run() 메소드가 자동으로 실행됨
        t2.start();
    }
  
}
