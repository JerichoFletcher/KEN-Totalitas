package ken.backend.kelas.inventory;

import ken.backend.kelas.barang.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<Integer, Barang> listBarang;

    public Inventory() {
        this.listBarang = new HashMap<>();
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