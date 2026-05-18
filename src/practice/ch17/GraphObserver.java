package practice.ch17;


// 관찰자 
public class GraphObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) { // 통지받을 때 호출되는 메소드
        System.out.print("GraphObserver:"); //println 은 줄 바꿈 print는 줄 안바꿈
        int count = generator.getNumber();


        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
        System.out.println(""); //빈칸 찍음
        try {
            Thread.sleep(1000); // 1초 대기한다./ 100 이면 0.1초 대기한다.
        } catch (InterruptedException e) {
        }
    }
}
