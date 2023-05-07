package ken.backend.kelas;

import ken.backend.dataStore.AdapterData;
import ken.backend.kelas.inventory.InventoryHolder;

import java.io.IOException;
import java.net.URI;

public interface Holder {
    public void load(URI uri, AdapterData data) throws IOException;
    public void write(URI uri, AdapterData data) throws IOException;
}
