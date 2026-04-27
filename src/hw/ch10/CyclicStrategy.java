package hw.ch10;

public class CyclicStrategy implements Strategy {
    private int currentHandValue = 0;

    @Override
    public Hand nextHand() {
        Hand hand = Hand.getHand(currentHandValue);
        currentHandValue = (currentHandValue + 1) % 3;
        return hand;
    }

    @Override
    public void study(boolean win) {
        // 승패와 관계없이 바위 -> 가위 -> 보 순서로 반복하므로 아무 작업도 하지 않는다.
    }
}