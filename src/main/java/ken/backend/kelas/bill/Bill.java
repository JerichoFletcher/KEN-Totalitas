package ken.backend.kelas.bill;
import ken.backend.kelas.barang.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.HashMap;

public class Bill {
    @Getter
    private Map<Integer,BillItem> listBarang;
    @Getter
    @Setter
    private boolean isFixed;
    private int idBill;
    private static int nextId = 1;

    public Bill() {
        this.listBarang = new HashMap<>();
        this.idBill = nextId;
        nextId++;
    }
    public int getBanyakBarang() {
        return listBarang.size();
    }
    public void addBarang(BillItem b) {
        this.listBarang.put(0, b);
    }
    public BillItem getBillItemById(int id){
        return listBarang.get(id);
    }
//    public void tambahBarang(BillItem barang) {
//        listBarang.add(barang);
//    }
    public void removeBarang(BillItem barang) {listBarang.remove(barang);}

}
