package ken.backend.kelas.bill;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.HashMap;

public class Bill {
    private Map<Integer, BillItem> listBarang;
    @Getter
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
        this.listBarang.put(getIdBill(), b);
    }
    public BillItem getBillItemById(int id){
        return listBarang.get(id);
    }
}
