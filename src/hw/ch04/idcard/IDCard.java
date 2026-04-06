package hw.ch04.idcard;

import hw.ch04.framework.Product;

public class IDCard extends Product {
    private String owner;
    private int serial;
    private String issuedDate;

    IDCard(String owner, int serial, String issuedDate) {
        System.out.println(owner + "의 카드를 " + serial + "번으로 만듭니다.");
        this.owner = owner;
        this.serial = serial;
        this.issuedDate = issuedDate;
    }

    @Override
    public void use() {
        System.out.println(this.toString() + "을 사용합니다.");
    }

    @Override
    public String toString() {
        return "[IDCard:" + owner + "(" + serial + ")] - 발급일: " + issuedDate;
    }

    public String getOwner() {
        return owner;
    }

    public int getSerial() {
        return serial;
    }

    public String getIssuedDate() {
        return issuedDate;
    }
}