package practice.ch02.inheritance;

public class Main {
    public static void main(String[] args) {
        Banner banner = new Banner("Hello World");
        banner.showWithParen();
        banner.showWithAster();

        //어댑터 이용
        System.out.println("어댑터 이용");
        Print print = new PrintBannerAdapter01("Hello World");
        print.printWeak();  
        print.printStrong();
        
    }
}
