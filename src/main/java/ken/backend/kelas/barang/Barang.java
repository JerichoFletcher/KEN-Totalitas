package ken.backend.kelas.barang;

import ken.backend.controller.holder.InventoryHolder;
import lombok.*;

import java.io.Serializable;
import java.util.Random;

public class Barang implements Serializable {
    @Getter
    private int id;
    @Getter
    @Setter
    private int stok;
    @Getter
    @Setter
    private String namaBarang;
    @Getter
    @Setter
    private float hargaBarang;
    @Getter
    @Setter
    private float hargaBeliBarang;
    @Getter
    @Setter
    private String kategori;
    @Getter
    @Setter
    private String gambar;

    private static Random rand = new Random();

    public Barang(String n, int s, float hj, float hb, String k, String g){
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

    public Barang(String n, int s, float hj, float hb, String k, String g, int id){
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