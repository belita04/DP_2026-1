package practice.ch04.idcard;

import practice.ch04.framework.Factory;
import practice.ch04.framework.Product;

public class IDCardFactory extends Factory {
    @Override
    // 부모 타입은 자식 객체를 참조할 수 있다.
    // 부모 객체는 자식타입이 참조할 수 없다.
    protected Product createProduct(String owner) {
        return new IDCard(owner); //신분증 생산
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.println(product.toString() + "을 등록했습니다."); //.toSring은 생략 가능
    }
}
