package practice.ch19;


// 주간 상태를 나타내는 클래스
public class DayState implements State {
    private static DayState singleton = new DayState(); // singleton 패턴을 적용하기 위해 클래스 내부에 static으로 객체를 생성

    private DayState() { //singleton 패턴을 적용하기 위해 생성자를 private으로 선언
    }

    public static State getInstance() {
        return singleton; // singleton 패턴을 적용하기 위해 getInstance() 메소드를 통해 객체를 반환
    }

    @Override
    public void doClock(Context context, int hour) {
        if (hour < 9 || 17 <= hour) { // 야간 시간이면...
            context.changeState(NightState.getInstance()); // 야간 상태로 전환
        }
    }

    @Override
    public void doUse(Context context) {
        context.recordLog("금고사용(주간)");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨(주간)");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("일반 통화(주간)");
    }

    @Override
    public String toString() {
        return "[주간]";
    }
}
