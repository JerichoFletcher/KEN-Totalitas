package ken.backend.kelas.bill;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class BillItem implements Serializable {
    @Getter
    private int id;
    @Getter
    private String namaBarang;
    @Getter
    @Setter
    private int jumlahDibeli;
    @Getter
    @Setter
    private float hargaBarang;
    public BillItem(String s, int jd, float hb, int id){
        this.id = id;
        this.namaBarang = s;
        this.jumlahDibeli = jd;
        this.hargaBarang = hb;
    }
}
