package ken.backend.kelas.bill;
import ken.backend.kelas.barang.*;
import java.util.ArrayList;

public class Bill {
    private ArrayList<Barang> listBarang;
    private boolean isFixed;
    
    public Bill() {
        this.listBarang = new ArrayList<Barang>();
        this.isFixed = false;
    }

    public void makeBillFixed(){
        this.isFixed = true;
    }

    public void tambahBarang(Barang barang) {
        listBarang.add(barang);
    }

    public ArrayList<Barang> getListBarang() {
        return listBarang;
    }

    public int getTotalHarga(){
        int total = 0;
        for(Barang b : this.listBarang){
            total += b.getHargaJual();
        }
        return total;
    }
}
