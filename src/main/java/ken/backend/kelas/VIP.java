package ken.backend.kelas;

public class VIP extends Member {
    private static final double DISCOUNT_RATE = 0.1;

    public VIP(String name, String phoneNumber) {
        super(name, phoneNumber);
    }

    public double getDiscountRate() {
        return DISCOUNT_RATE;
    }
}