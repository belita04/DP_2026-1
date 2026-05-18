package hw.ch17;

import java.util.ArrayList;
import java.util.List;

// 관찰 대상
public abstract class NumberGenerator {
    // Observer들을 저장한다.
    // Observer 부모 타입으로 저장하기 때문에 다양한 관찰자를 등록할 수 있다.
    private List<Observer> observers = new ArrayList<>();

    // Observer를 추가한다.
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Observer를 제거한다.
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    // 등록된 모든 Observer에게 상태 변화를 통지한다.
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }

    // 현재 수를 반환한다.
    public abstract int getNumber();

    // 수를 생성한다.
    public abstract void execute();
}