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
    public Inventory(ArrayList<Barang> listBarang) {
        this.listBarang = listBarang;
    }

    public Inventory( Inventory inv) {
        this.listBarang = new ArrayList<Barang>();
        for (Barang barang: inv.listBarang) {
            addBarang(barang);
        }
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