package ken.backend.kelas.inventory;
import ken.backend.kelas.barang.*;
import java.util.ArrayList;

public class Inventory {
    private ArrayList<Barang> listBarang;

    public Inventory() {
        this.listBarang = new ArrayList<Barang>();
    }

    public int getBanyakBarang() {
        return listBarang.size();
    }

    public void addBarang(Barang b){
        this.listBarang.add(b);
    }
}