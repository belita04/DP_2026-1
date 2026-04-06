package practice.ch05.ex;

public class Main extends Thread {
    public static void main(String[] args) {
      // 스레드 객체 생성
      Main t1 = new Main("Thread-A");
      Main t2 = new Main("Thread-B");

      // 스레드에 시작해라 지시
      t1.start(); // 스레드가 해야할 일을 작성한 run() 메소드가 자동으로 실행됨
      t2.start();
    }

    // 스레드가 해야할 일을 작성
    @Override
    public void run() {
      Singleton s = Singleton.getInstance();
      System.out.println(getName() + ": " + s); // 스레드 이름과 싱글턴 인스턴스의 주소값 출력

  }

    
    public Main(String name) {
      super(name); // 부모인 Thread의 생성자를 호출해서 스레드 이름 설정
    }

}