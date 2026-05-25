package practice.ch20;

import java.util.HashMap;
import java.util.Map;

public class BigCharFactory {
    // 이미 만든 BigChar 인스턴스를 관리 
    private Map<String,BigChar> pool = new HashMap<>(); // <key , value> 사용

    // Singleton 패턴 
    private static BigCharFactory singleton = new BigCharFactory();

    // 생성자 ...singleton 패턴이므로 private으로 선언하여 외부에서 인스턴스 생성을 못하게 함
    private BigCharFactory() {
    }

    // 유일한 인스턴스를 얻는다...singleton 패턴이므로 getInstance() 메서드를 통해서만 인스턴스를 얻을 수 있음
    public static BigCharFactory getInstance() {
        return singleton;
    }

    // BigChar 인스턴스 생성(공유)
    public synchronized BigChar getBigChar(char charname) { // ex '3'

         // 이미 만들어진 BigChar 인스턴스를 검색
        BigChar bc = pool.get(String.valueOf(charname)); // stirng으로 만들어줌 "3"

        
        if (bc == null) { // 이미 만들어진 BigChar 인스턴스가 없다면...
            // 여기서 BigChar 인스턴스를 생성 
            bc = new BigChar(charname);
            pool.put(String.valueOf(charname), bc);
        }
        return bc;
        
    }
}
