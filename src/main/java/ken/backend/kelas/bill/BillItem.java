package ken.backend.kelas.bill;

import lombok.Getter;
import lombok.Setter;

public class BillItem {
    @Getter
    private String namaBarang;
    @Getter
    @Setter
    private int jumlahDibeli;
    @Getter
    @Setter
    private int hargaBarang;
}
