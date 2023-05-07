package ken.backend.kelas.inventory;

import ken.backend.dataStore.AdapterData;
import ken.backend.kelas.Holder;
import ken.backend.kelas.barang.*;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class InventoryHolder implements Holder {
    private static InventoryHolder _instance = null;
    public static InventoryHolder instance() {
        if (_instance == null) {
            _instance = new InventoryHolder();
        }
        return _instance;
    }

    @Getter
    @Setter
    private Map<Integer, Barang> listBarang;

    private InventoryHolder() {
        this.listBarang = new HashMap<>();
    }

    public void load(URI uri, AdapterData data) throws IOException {
        _instance = data.get(uri, InventoryHolder.class);
    }

    public void write(URI uri, AdapterData data) throws IOException {
        data.write(uri, InventoryHolder.instance());
    }

    public int getBanyakBarang() {
        return listBarang.size();
    }

    public void addBarang(Barang b) {
        this.listBarang.put(b.getId(), b);
    }

    public Barang getBarangById(int id){
        return listBarang.get(id);
    }

    public void setListBarang(Map <Integer, Barang> listBarang){
        this.listBarang = listBarang;
    }
}