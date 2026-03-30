package practice.ch04.idcard;

import practice.ch04.framework.Product;

public class IDCard extends Product {
    private String owner;

    IDCard(String owner) {
        System.out.println(owner + "의 카드를 만듭니다."); // 문자열 + 문자열
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println(this.toString() + "을 사용합니다."); // 객체.toString()  + 문자열
    }

    @Override
    // Object 클래스의 toSting 메소드 오버라이드
    public String toString() {
        return "[IDCard:" + owner + "]";
    }

    public String getOwner() {
        return owner;
    }
}
