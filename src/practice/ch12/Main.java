package practice.ch12;

public class Main {

  public static void main(String[] args) {
    Display d1 = new StringDisplay("Hello, world."); //중심
    d1.show();

    Display d2 = new SideBorder(d1, '#'); //장식자 1
    d2.show();

    Display d3 = new SideBorder(d2, '*'); //장식자 1-2
    d3.show();

    Display d4 = new FullBorder(d1); // 장식자 2
    d4.show();

    Display d5 = new SideBorder(d4, '/'); // 장식자 2-1
    d5.show();  
  }

  
}

