package ken.backend.kelas.bill;
import ken.backend.dataStore.AdapterData;
import ken.backend.kelas.Holder;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class FixedBillHolder implements Holder {
    private static FixedBillHolder _instance = null;
    public static FixedBillHolder instance() {
        if (_instance == null) {
            _instance = new FixedBillHolder();
        }
        return _instance;
    }
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

}