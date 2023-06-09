package ken.backend.kelas.bill;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class BillItem implements Serializable {

    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String namaBarang;
    @Getter
    @Setter
    private int jumlahDibeli;
    @Getter
    @Setter
    private float hargaBarang;
    public BillItem(int id, String s, int jd, float hb){

        this.id = id;
        this.namaBarang = s;
        this.jumlahDibeli = jd;
        this.hargaBarang = hb;
    }
}
