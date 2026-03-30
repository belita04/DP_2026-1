package practice.ch02.delegation;

// 어댑터
// 자바에서는 다중 상속이 불가능함(부모가 둘 이상은 허용이 안 됨)
public class PrintBannerAdapter02 extends Print { //추상클래스는 implementr가 아니라 extends로 상속받는다.
    private Banner banner; //Banner 클래스의 인스턴스를 참조하는 필드

    public PrintBannerAdapter02(String text) {
        this.banner = new Banner(text);  //Banner 클래스의 인스턴스를 생성하여 필드에 할당
    }

    @Override
    public void printWeak() {
        banner.showWithParen(); //Banner 클래스의 메서드를 호출하여 기능을 수행(위임)
    }

    @Override
    public void printStrong() {
        banner.showWithAster(); //Banner 클래스의 메서드를 호출하여 기능을 수행(위임)
    }


    
  
}
