package ken.backend.kelas.inventory;

import ken.backend.dataStore.AdapterData;
import ken.backend.kelas.barang.*;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private static Inventory _instance = null;
    public static Inventory instance() {
        if (_instance == null) {
            _instance = new Inventory();
        }
        return _instance;
    }

    private Map<Integer, Barang> listBarang;

    private Inventory() {
        this.listBarang = new HashMap<>();
    }

    public void load(URI uri, AdapterData data) throws IOException {
        _instance = data.get(uri, Inventory.class);
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
}