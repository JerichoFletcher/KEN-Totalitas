package ken.backend.kelas.bill;

import lombok.Getter;
import lombok.Setter;

<<<<<<< Updated upstream
import java.io.Serializable;

public class BillItem implements Serializable {
=======
public class BillItem {
>>>>>>> Stashed changes
    @Getter
    private int id;
    @Getter
    private String namaBarang;
    @Getter
    @Setter
    private int jumlahDibeli;
    @Getter
    @Setter
<<<<<<< Updated upstream
    private float hargaBarang;
    public BillItem(String s, int jd, float hb, int id){
=======
    private int hargaBarang;
    public BillItem(int id, String s, int jd, int hb){
>>>>>>> Stashed changes
        this.id = id;
        this.namaBarang = s;
        this.jumlahDibeli = jd;
        this.hargaBarang = hb;
    }
}
