package hw.ch12;

// 장식자를 대표하는 추상 클래스
public abstract class Border extends Display {
    protected Display display;   // 장식 대상

    protected Border(Display display) {
        this.display = display;
    }
}