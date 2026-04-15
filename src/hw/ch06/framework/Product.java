package hw.ch06.framework;

public interface Product extends Cloneable {
    void use(String s);
    Product createCopy();
}