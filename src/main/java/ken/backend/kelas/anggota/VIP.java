package ken.backend.kelas.anggota;

public class VIP extends Member {
    private static final double DISCOUNT_RATE = 0.1;

    public VIP(String name, String phoneNumber, int id) {
        super(name, phoneNumber,id);
    }

    public double getDiscountRate() {
        return DISCOUNT_RATE;
    }
}