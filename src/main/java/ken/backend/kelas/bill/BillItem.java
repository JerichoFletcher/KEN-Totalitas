package ken.backend.kelas.bill;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class BillItem implements Serializable {
    
    @Getter
    private String namaBarang;
    @Getter
    @Setter
    private int jumlahDibeli;
    @Getter
    @Setter
    private int hargaBarang;
    public BillItem(String s, int jd, int hb){
        this.namaBarang = s;
        this.jumlahDibeli = jd;
        this.hargaBarang = hb;
    }
}
