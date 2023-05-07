package ken.backend.kelas.bill;
import ken.backend.dataStore.AdapterData;
import ken.backend.kelas.holder.Holder;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class BillHolder implements Holder {
    private static BillHolder _instance = null;
    public static BillHolder instance() {
        if (_instance == null) {
            _instance = new BillHolder();
        }
        return _instance;
    }
    private Map<Integer, Bill> listBill;
    
    public BillHolder() {
        this.listBill = new HashMap<>();
    }
    public int getBanyakBill() {
        return listBill.size();
    }
    public void load(URI uri, AdapterData data) throws IOException {
        _instance = data.get(uri, BillHolder.class);
    }
    public void write(URI uri, AdapterData data) throws IOException {
        data.write(uri, BillHolder.instance());
    }
    public Bill getBillById(int id){
        return listBill.get(id);
    }

}
