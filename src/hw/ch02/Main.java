package hw.ch02;

public class Main {
    public static void main(String[] args) {
        System.out.println("20240761 이명진");

        KoreanOutlet koreanOutlet = new KoreanOutlet();
        Charger charger = new KoreanOutletAdapter(koreanOutlet);
        Smartphone smartphone = new Smartphone(charger);

        smartphone.charge();
    }
}