package ken.backend.controller.holder;
import ken.backend.dataStore.AdapterData;
import ken.backend.kelas.barang.Barang;
import ken.backend.kelas.bill.Bill;
import ken.backend.kelas.bill.BillItem;
import ken.gui.MenuItem;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@XmlRootElement
public class FixedBillHolder implements Holder, Serializable {
    private static FixedBillHolder _instance = null;
    public static FixedBillHolder instance() {
        if (_instance == null) {
            _instance = new FixedBillHolder();
        }
        return _instance;
    }

    @Getter
    @Setter
    private Map<Integer, Bill> listBill;
    
    public FixedBillHolder() {
        this.listBill = new HashMap<>();
    }
    public int getBanyakBill() {
        return listBill.size();
    }
    public void load(URI uri, AdapterData data) throws Exception {
        _instance = data.get(uri, FixedBillHolder.class);
    }
    public void write(URI uri, AdapterData data) throws Exception {
        data.write(uri, FixedBillHolder.instance());
    }
    public Bill getBillById(int id){
        return listBill.get(id);
    }
    public void addBill(Bill bb){
        this.listBill.put(bb.getIdBill(),bb);
    }

    public List<Bill> getBillPerCustomer(int id){
        List<Bill> listBillCust = new ArrayList<Bill>();
        for (Map.Entry<Integer, Bill> entry : this.listBill.entrySet()) {
            Integer key = entry.getKey();
            Bill value = entry.getValue();
            if(value.getIdCustomer()==id){
                listBillCust.add(value);
            }
        }
        return listBillCust;
    }

}
