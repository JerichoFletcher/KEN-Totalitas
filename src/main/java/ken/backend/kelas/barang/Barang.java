package ken.backend.kelas.barang;

import ken.backend.controller.holder.InventoryHolder;
import lombok.*;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Random;
@XmlRootElement
public class Barang implements Serializable {
//    @XmlAttribute
    @Getter
    @Setter
    private int id;
//    @XmlAttribute
    @Getter
    @Setter
    private int stok;
//    @XmlAttribute
    @Getter
    @Setter
    private String namaBarang;
//    @XmlAttribute
    @Getter
    @Setter
    private float hargaBarang;
//    @XmlAttribute
    @Getter
    @Setter
    private float hargaBeliBarang;
//    @XmlAttribute
    @Getter
    @Setter
    private String kategori;
//    @XmlAttribute
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

    public Barang(){
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

    public void modifyStok(int s){
        this.stok = Math.max(s, 0);
    }

    public void setHargaJual(int s){
        this.hargaBarang = Math.max(s, 0);
    }

    public void modifyHargaBeli(int s){
        this.hargaBeliBarang = Math.max(s, 0);
    }
}