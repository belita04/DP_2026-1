package practice.ch03;

public class Main {
    public static void main(String[] args) {
        //CharDisplay d1 = new CharDisplay('H');
        AbstractDisplay d1 = new CharDisplay('H'); //위의 주석과 같이 똑같이 실행, 꼭 타입이 같지 않아도 됨 
        d1.display();
        d1.open();

        //StringDisplay d2 = new StringDisplay("Hello, world."); // "Hello, world."
        AbstractDisplay d2 = new StringDisplay("Hello, world."); //부모타입으로 선언하면 어떤 자식이 오더라도 동작하면 LSP원칙을 잘 지킨 것
        d2.display();

        // AbstractDisplay d3 = new AbstractDisplay(); 불가능 

    }
}
