package ch03.A4;

public interface AbstractDisplay { //interface로 바꿀때 default를 붙임
    public void open();
    public void print();
    public void close();

    public default void display() { //interface에서 구현하려면 default를 붙여야함 그래야 메소드 제공가능
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
