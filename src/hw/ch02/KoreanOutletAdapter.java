package hw.ch02;

public class KoreanOutletAdapter implements Charger {
    private KoreanOutlet koreanOutlet;

    public KoreanOutletAdapter(KoreanOutlet koreanOutlet) {
        this.koreanOutlet = koreanOutlet;
    }

    @Override
    public int charge() {
        return koreanOutlet.provide();
    }
}