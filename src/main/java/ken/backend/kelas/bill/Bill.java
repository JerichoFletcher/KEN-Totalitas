package ken.backend.kelas.bill;
import ken.backend.kelas.barang.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Bill {
    @Getter
    private ArrayList<BillItem> listBarang;
    @Getter
    @Setter
    private boolean isFixed;
    
    public Bill() {
        this.listBarang = new ArrayList<BillItem>();
    }
    public void tambahBarang(BillItem barang) {
        listBarang.add(barang);
    }
    public void removeBarang(BillItem barang) {listBarang.remove(barang);}

}
