package ken.backend.controller.holder;

import ken.backend.dataStore.AdapterData;
import ken.backend.kelas.anggota.Customer;
import ken.backend.kelas.anggota.VIP;
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
public class VIPHolder implements Holder, Serializable {
    private static VIPHolder _instance = null;
    public static VIPHolder instance(){
        if(_instance == null){
            _instance = new VIPHolder();
        }
        return _instance;
    }
    @Getter
    @Setter
    private Map<Integer, VIP> listVIP;

    private VIPHolder(){
        this.listVIP = new HashMap<>();
    }

    public void load(URI uri, AdapterData data) throws Exception {
        _instance = data.get(uri, VIPHolder.class);
    }

    public void write(URI uri, AdapterData data) throws Exception {
        data.write(uri, VIPHolder.instance());
    }
    public int getBanyakVIP(){
        return listVIP.size();
    }
    public void addVIP(VIP c) {
        this.listVIP.put(c.getId(),c);
    }
    public void removeVIP(int id) {
        this.listVIP.remove(id);
    }
    public VIP getVIPById(int id) {
        return listVIP.get(id);
    }
}
