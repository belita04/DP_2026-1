package hw.ch20;

import java.util.HashMap;
import java.util.Map;

public class BigCharFactory {
    // 이미 만든 BigChar 인스턴스를 관리하는 pool
    private Map<String, BigChar> pool = new HashMap<>();

    // Singleton 패턴
    private static BigCharFactory singleton = new BigCharFactory();

    // 생성자를 private으로 선언하여 외부에서 new로 생성하지 못하게 함
    private BigCharFactory() {
    }

    // 유일한 BigCharFactory 인스턴스를 반환
    public static BigCharFactory getInstance() {
        return singleton;
    }

    // BigChar 인스턴스 생성 및 공유
    public synchronized BigChar getBigChar(char charname) {
        BigChar bc = pool.get(String.valueOf(charname));

        if (bc == null) {
            bc = new BigChar(charname);
            pool.put(String.valueOf(charname), bc);
        }

        return bc;
    }
}