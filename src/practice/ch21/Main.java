package practice.ch21;

public class Main {
  
  // 본인 생성
  // Printable p1 = new Printer("Alice");
  // p1.print("Hello, world.");

  // 프록시를 생성해서 이용
    Printable p2 = new PrinterProxy();
    p2.setPrinterName("Bob");
    System.out.println("현재 프린터 이름은 " + p2.getPrinterName() + "입니다.");
  
  

}
