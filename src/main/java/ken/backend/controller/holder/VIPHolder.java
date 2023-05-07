package ken.backend.controller.holder;

import ken.backend.dataStore.AdapterData;
import ken.backend.kelas.anggota.Customer;
import ken.backend.kelas.anggota.VIP;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class VIPHolder implements Holder {
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

    public void load(URI uri, AdapterData data) throws IOException {
        _instance = data.get(uri, VIPHolder.class);
    }

    public void write(URI uri, AdapterData data) throws IOException {
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
    public Customer getVIPById(int id) {
        return listVIP.get(id);
    }
}
