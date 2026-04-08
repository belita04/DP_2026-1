package practice.ch06;

import practice.ch06.MessageBox;
import practice.ch06.framework.Manager;
import practice.ch06.framework.Product;

public class Main {
    public static void main(String[] args) {
      /* 
      //원본(prototype)이 일을 함
      MessageBox mbox1 = new MessageBox('*');
      mbox1.use("Hello, world.");

      //복제된 객체가 일을 함
      mbox1.createCopy().use("Hello, world.");
      //mbox1.clone();

      //원본(prototype)이 일을 함
      UnderlinePen upen1 = new UnderlinePen('+');
      upen1.use("Hello, world.");

      //복제된 객체가 일을 함
      upen1.createCopy().use("Hello, world.");
      */

      //Manager를 이용하는 코드

      //Manager에 원본(prototype)을 등록

      //준비
      Manager manager = new Manager();
      MessageBox mbox1 = new MessageBox('*');
      MessageBox mbox2 = new MessageBox('/'); 
      UnderlinePen upen1 = new UnderlinePen('+');

      //등록
      manager.register("star box", mbox1);
      manager.register("plus line", upen1);
      manager.register("slash box", mbox2);

      //등록된 이름으로 복제품을 얻어서 사용
      Product p1 = manager.create("star box");
      p1.use("Hello, world.");

      Product p2 = manager.create("plus line");
      p2.use("Hello, world.");

      Product p3 = manager.create("slash box");
      p3.use("Hello, world.");

    }
}
