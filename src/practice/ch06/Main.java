package practice.ch06;

import practice.ch06.MessageBox;

public class Main {
    public static void main(String[] args) {
      MessageBox mbox1 = new MessageBox('*');
      mbox1.use("Hello, world.");

      mbox1.createCopy().use("Hello, world.");

    }
}
