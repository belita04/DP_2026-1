package practice.ch04.framework;

public abstract class Factory {
    // 템플릿 메소드
    //제품 생산하는 방식을 정의하는 메소드
    public final Product create(String owner) {
        Product p = createProduct(owner); // 실제 제품 생산
        registerProduct(p); // 생산된 제품을 등록
        return p;
    }
    // 팩토리 메소드
    protected abstract Product createProduct(String owner);
    //protected Product createProduct(String owner){};
//하위 클래스에서 구현을 준비라지 않았을 경우를 위한 디폴트 구현 준비

    
    protected abstract void registerProduct(Product product);
}
