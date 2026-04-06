package hw.ch04.idcard;

import hw.ch04.framework.Factory;
import hw.ch04.framework.Product;

public class IDCardFactory extends Factory {
    private String baseDate;
    private int serialCounter;

    public IDCardFactory(String baseDate) {
        this.baseDate = baseDate;
        this.serialCounter = 1;
    }

    @Override
    protected Product createProduct(String owner) {
        IDCard card = new IDCard(owner, serialCounter, baseDate);
        serialCounter++;
        return card;
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.println(product.toString() + "을 등록했습니다.");
    }
}