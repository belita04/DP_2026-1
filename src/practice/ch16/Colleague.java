package practice.ch16;

// 맴버(동료)를 위한 인터페이스
public interface Colleague {
    // Mediator를 설정한다 
    public abstract void setMediator(Mediator mediator);

    // Mediator에서 활성/비활성을 지시한다
    public abstract void setColleagueEnabled(boolean enabled); // TRUE 면 활성화
}
