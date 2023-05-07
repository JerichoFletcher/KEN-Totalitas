package ken.backend.kelas.barang;

import ken.backend.controller.holder.InventoryHolder;
import lombok.*;

import java.util.Random;

public class Barang {
    @Getter
    private int id;
    @Getter
    private int stok;
    @Getter
    private String namaBarang;
    @Getter
    private int hargaBarang;
    @Getter
    @Setter
    private int hargaBeliBarang;
    @Getter
    @Setter
    private String kategori;
    @Getter
    @Setter
    private String gambar;

    private static Random rand = new Random();

    public Barang(String n, int s, int hj, int hb, String k, String g){
        InventoryHolder inv = InventoryHolder.instance();
        int id = rand.nextInt(Integer.MAX_VALUE);
        for(; inv.getBarangById(id) != null; id = rand.nextInt(Integer.MAX_VALUE));
        this.stok = s;
        this.namaBarang = n;
        this.hargaBarang = hj;
        this.hargaBeliBarang = hb;
        this.kategori = k;
        this.gambar = g;
        this.id = id;
    }

    public Barang(String n, int s, int hj, int hb, String k, String g, int id){
        this.stok = s;
        this.namaBarang = n;
        this.hargaBarang = hj;
        this.hargaBeliBarang = hb;
        this.kategori = k;
        this.gambar = g;
        this.id = id;
    }

    public void setStok(int s){
        this.stok = Math.max(s, 0);
    }

    public void setHargaJual(int s){
        this.hargaBarang = Math.max(s, 0);
    }

    public void modifyHargaBeli(int s){
        this.hargaBeliBarang = Math.max(s, 0);
    }
}