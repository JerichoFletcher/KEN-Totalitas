package ken.backend.controller.holder;
import ken.backend.dataStore.AdapterData;
import ken.backend.kelas.bill.Bill;
import ken.backend.kelas.bill.BillItem;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement
public class BillHolder implements Holder, Serializable {
    private static BillHolder _instance = null;
    public static BillHolder instance() {
        if (_instance == null) {
            _instance = new BillHolder();
        }
        return _instance;
    }
    @Getter
    @Setter
    private Map<Integer, Bill> listBill;
    
    public BillHolder() {
        this.listBill = new HashMap<>();
    }
    public int getBanyakBill() {
        return listBill.size();
    }
    public void load(URI uri, AdapterData data) throws Exception {
        _instance = data.get(uri, BillHolder.class);
    }
    public void write(URI uri, AdapterData data) throws Exception {
        data.write(uri, BillHolder.instance());
    }
    public Bill getBillById(int id){
        return listBill.get(id);
    }
    public void addBill(Bill bb){
        this.listBill.put(bb.getIdBill(),bb);
    }

}
