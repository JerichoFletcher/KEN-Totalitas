package ken.backend.dataStore;

import ken.backend.kelas.anggota.Member;
import ken.backend.kelas.barang.Barang;
import ken.backend.kelas.inventory.Inventory;

import java.io.IOException;
import java.net.URI;
import java.util.List;

public interface AdapterData {
    public Inventory getInventory(URI uri) throws IOException;
//    public Bill[] getFixedBill();
//    public Bill[] getBill();
}
