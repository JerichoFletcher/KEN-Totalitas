package ken.backend.kelas.barang;

import lombok.*;

public class Barang {
    @Getter
    private int id;
    private static int nextId = 1;
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
    private String gambar;

    public Barang(int s, String n, int hj, int hb, String k, String g){
        this.stok = s;
        this.namaBarang = n;
        this.hargaBarang = hj;
        this.hargaBeliBarang = hb;
        this.kategori = k;
        this.gambar = g;
        this.id = nextId;
        nextId++;
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


