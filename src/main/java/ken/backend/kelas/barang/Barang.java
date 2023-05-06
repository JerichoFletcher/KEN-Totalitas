package ken.backend.kelas.barang;

public class Barang {
    private int stok;
    private String nama;
    private int hargaJual;
    private int hargaBeli;
    private String kategori;
    private String gambar;

    public Barang(int s, String n, int hj, int hb, String k, String g){
        this.stok = s;
        this.nama = n;
        this.hargaJual = hj;
        this.hargaBeli = hb;
        this.kategori = k;
        this.gambar = g;
    }

    public void addStok(int s){
        this.stok += s;
    }

    public void kurangiStok(int s){
        if(this.stok - s > 0){
            this.stok-=s;
        }
        else{
            this.stok=0;
        }
    }

    public void addhargaJual(int s){
        this.hargaJual += s;
    }

    public void kurangihargaJual(int s){
        if(this.hargaJual - s > 0){
            this.hargaJual-=s;
        }
        else{
            this.hargaJual=0;
        }
    }

    public void addhargaBeli(int s){
        this.hargaBeli += s;
    }

    public void kurangihargaBeli(int s){
        if(this.hargaBeli - s > 0){
            this.hargaBeli-=s;
        }
        else{
            this.hargaBeli=0;
        }
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(int hargaJual) {
        this.hargaJual = hargaJual;
    }

    public int getHargaBeli() {
        return hargaBeli;
    }

    public void setHargaBeli(int hargaBeli) {
        this.hargaBeli = hargaBeli;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    } 

}


