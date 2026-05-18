package practice.ch19;


// 야간 상태를 나타내는 클래스
public class NightState implements State {
    private static NightState singleton = new NightState(); // singleton 패턴을 적용하기 위해 클래스 내부에 static으로 객체를 생성

    private NightState() { //singleton 패턴을 적용하기 위해 생성자를 private으로 선언   
    }

    public static State getInstance() {// singleton 패턴을 적용하기 위해 getInstance() 메소드를 통해 객체를 반환
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (9 <= hour && hour < 17) { // 주간 시간이면...
            context.changeState(DayState.getInstance()); // 주간 상태로 전환
        }
    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("비상：야간 금고 사용！");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨(야간)");
    }

    @Override
    public void doPhone(Context context) {
        context.recordLog("야간 통화 녹음");
    }

    @Override
    public String toString() {
        return "[야간]";
    }
}
