package hw.ch19;

// 비상 상태
public class UrgentState implements State {
    private static UrgentState singleton = new UrgentState();

    private UrgentState() {
    }

    public static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        // 비상 상태에서는 시간에 따른 상태 전환을 하지 않는다.
    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("비상:비상시 금고 사용!");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨(비상시)");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("일반 통화(비상시)");
    }

    @Override
    public String toString() {
        return "[비상시]";
    }
}