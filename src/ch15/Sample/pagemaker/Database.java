package ch15.Sample.pagemaker;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Database {
    private Database() {
    }

    // 데이터베이스 이름에서 Properties를 얻는다  key=value 형식의 파일을 읽어서 Properties 객체로 반환한다
    public static Properties getProperties(String dbname) throws IOException {
        String filename = dbname + ".txt";
        Properties prop = new Properties();
        prop.load(new FileReader(filename)); // 프러퍼티 파일에서 모든 데이터(키와 값)를 읽는다.
        return prop;
    }
}

