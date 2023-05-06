package ken.backend.dataStore;

import ken.backend.kelas.anggota.Member;
import ken.backend.kelas.barang.Barang;
import ken.backend.kelas.inventory.Inventory;

import java.io.IOException;
import java.net.URI;
import java.util.List;

public interface AdapterData {
    public <T> T get(URI uri, Class<T> clazz) throws IOException;

    public <T> void write(URI uri, Class<T> clazz) throws  IOException;

//    public Bill[] getFixedBill();
//    public Bill[] getBill();
}
