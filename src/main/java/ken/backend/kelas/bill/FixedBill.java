package ken.backend.kelas.bill;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.HashMap;

public class FixedBill {
    private Map<Integer, BillItem> listBarang;
    @Getter
    private int idFixedBill;
    private static int nextId = 1;
    
    public FixedBill() {
        this.listBarang = new HashMap<>();
        this.idFixedBill = nextId;
        nextId++;
    }
    public int getBanyakBarang() {
        return listBarang.size();
    }
    public void addBarang(BillItem b) {
        this.listBarang.put(getIdFixedBill(), b);
    }
    public BillItem getBillItemById(int id){
        return listBarang.get(id);
    }
}
