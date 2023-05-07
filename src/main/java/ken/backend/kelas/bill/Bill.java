package ken.backend.kelas.bill;
import ken.backend.controller.holder.BillHolder;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class Bill {
    @Getter
    @Setter
    private Map<Integer,BillItem> listBarang;
    @Getter
    @Setter
    private int idBill;
    @Getter
    @Setter
    private int idCustomer;
    @Getter
    private final Map<String, Integer> totalHarga = new HashMap<>();
    private static Random rand = new Random();

    public Bill(int idCustomer, String mataUang, int totalHarga) {
        BillHolder bh = BillHolder.instance();
        int id = rand.nextInt(Integer.MAX_VALUE);
        for(; bh.getBillById(id) != null; id = rand.nextInt(Integer.MAX_VALUE));
        this.listBarang = new HashMap<>();
        this.idBill = id;
        this.idCustomer = idCustomer;
        this.totalHarga.put(mataUang, totalHarga);
    }

    public Bill(int idBill, int idCustomer, String mataUang, int totalHarga, Map<Integer,BillItem> listBarang){
        this.idBill = idBill;
        this.idCustomer = idCustomer;
        this.totalHarga.put(mataUang, totalHarga);
        this.listBarang = listBarang;

    }
    public int getBanyakBarang() {
        return listBarang.size();
    }
    public void addBarang(BillItem b) {
        if(this.listBarang.isEmpty()){
            this.listBarang.put(0, b);
        }else{
            int maxId = Collections.max(listBarang.keySet());
            this.listBarang.put(maxId+1, b);
        }

    }
    public BillItem getBillItemById(int id){
        return listBarang.get(id);
    }
//    public void tambahBarang(BillItem barang) {
//        listBarang.add(barang);
//    }
    public void removeBarang(int id) {listBarang.remove(id);}

}
