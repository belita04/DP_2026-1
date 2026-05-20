package ch20.Sample;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) { //인자가 없으면...
            System.out.println("Usage: java Main digits");
            System.out.println("Example: java Main 1212123");
            System.exit(0);
        }

        BigString bs = new BigString(args[0]); //인자로 받은 문자열로 BigString 객체를 생성한다.
        bs.print();
    }
}
