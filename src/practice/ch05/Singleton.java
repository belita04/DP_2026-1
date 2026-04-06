package practice.ch05;

// 싱글톤 패턴 적용하기 
public class Singleton {

    // (3) Singleton 객체를 미리 하나 만들어둠
    private static Singleton singleton = new Singleton(); //반드시 static이어야 함, 클래스가 로딩 될 때 Singleton 객체가 하나 만들어짐
  
   // (1) 생성자를 private으로 함
    private Singleton() {
      System.out.println("Singleton 객체가 생성됩니다.");
    }

    // (2) Singleton 객체를 얻어갈 수 있는 메소드를 정의함
    public static Singleton getInstance() {
        return  singleton; //return new SIngleton();이 변함
        
    }

}
