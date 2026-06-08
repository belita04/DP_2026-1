package practice.ch14;

import ch14.Sample.Trouble;

public abstract class Support {
    private String name;    // 이 트러블 해결자 이름
    private Support next;   // 떠넘길 곳(Support: 부모 타입 -> 모든 종류의 해결자들을 가리킬 수 있다.)

    public Support(String name) {
        this.name = name;
        this.next = null; //생성될 때는 떠넘길 곳이 없다.
    }

    // 떠넘길 곳을 설정한다
    public Support setNext(Support next) {
        this.next = next;
        return next; // 인자로 들어온 뒷사람을 반환함
    }

    // 트러블 해결 절차를 결정한다
    public void support(Trouble trouble) {
        if (resolve(trouble)) { // 내가 해결 시도
            done(trouble); // 해결했다고 선언
        } else if (next != null) { // 내가 해결 못 하고, 뒷사람이 있으면
            next.support(trouble); // 뒷사람에게 떠넘김
        } else { // 내가 해결 못 하고, 뒷사람도 없으면
            fail(trouble); // 해결 못 했다고 선언
        }
    }

    // 트러블 해결자의 문자열 표현
    @Override
    public String toString() {
        return "[" + name + "]";
    }

    // 해결하려고 한다
    protected abstract boolean resolve(Trouble trouble); // 추상메소드, 자식들이 해결 방법을 구현함(결정함)

    // 해결했다 
    protected void done(Trouble trouble) {
        System.out.println(trouble + " is resolved by " + this + ".");
    }

    // 해결되지 않았다 
    protected void fail(Trouble trouble) {
        System.out.println(trouble + " cannot be resolved.");
    }
}
