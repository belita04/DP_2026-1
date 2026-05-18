package practice.ch19;

// 상태를 나타내는 인터페이스
public interface State {
    public abstract void doClock(Context context, int hour);	// 시간 설정
    
    // 행동
    public abstract void doUse(Context context);		// 금고 사용 
    public abstract void doAlarm(Context context);		// 비상벨 
    public abstract void doPhone(Context context);		// 일반 통화 
}
