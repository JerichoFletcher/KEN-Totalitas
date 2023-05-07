package ken.backend.controller.holder;
import ken.backend.dataStore.AdapterData;
import ken.backend.kelas.bill.Bill;
import lombok.Getter;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class FixedBillHolder implements Holder, Serializable {
    private static FixedBillHolder _instance = null;
    public static FixedBillHolder instance() {
        if (_instance == null) {
            _instance = new FixedBillHolder();
        }
        return _instance;
    }

    @Getter
    private Map<Integer, Bill> listBill;
    
    public FixedBillHolder() {
        this.listBill = new HashMap<>();
    }
    public int getBanyakBill() {
        return listBill.size();
    }
    public void load(URI uri, AdapterData data) throws IOException {
        _instance = data.get(uri, FixedBillHolder.class);
    }
    public void write(URI uri, AdapterData data) throws IOException {
        data.write(uri, FixedBillHolder.instance());
    }
    public Bill getBillById(int id){
        return listBill.get(id);
    }
    public void addBill(Bill bb){
        this.listBill.put(bb.getIdBill(),bb);
    }

}
