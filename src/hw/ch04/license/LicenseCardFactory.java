package hw.ch04.license;

import java.time.LocalDate;

import hw.ch04.framework.Factory;
import hw.ch04.framework.Product;

public class LicenseCardFactory extends Factory {
    private int licenseCounter;
    private String baseDate;

    public LicenseCardFactory(String baseDate) {
        this.baseDate = baseDate;
        this.licenseCounter = 100;
    }

    @Override
    protected Product createProduct(String holder) {
        String expiryDate = calculateExpiryDate(baseDate);
        LicenseCard card = new LicenseCard(holder, licenseCounter, baseDate, expiryDate);
        licenseCounter++;
        return card;
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.println(product.toString() + "을 등록했습니다.");
    }

    private String calculateExpiryDate(String issuedDate) {
        LocalDate date = LocalDate.parse(issuedDate);
        return date.plusYears(5).minusDays(1).toString();
    }
}