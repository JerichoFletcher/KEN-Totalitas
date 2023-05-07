package ken.backend.kelas.anggota;

import java.io.Serializable;

public class VIP extends Member implements Serializable {
    private static final double DISCOUNT_RATE = 0.1;

    public VIP(String name, String phoneNumber, int id) {
        super(name, phoneNumber,id);
    }

    public double getDiscountRate() {
        return DISCOUNT_RATE;
    }
}