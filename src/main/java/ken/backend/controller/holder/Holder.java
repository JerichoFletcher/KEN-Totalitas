package ken.backend.controller.holder;

import ken.backend.dataStore.AdapterData;

import java.net.URI;

public interface Holder {
    public void load(URI uri, AdapterData data) throws Exception;
    public void write(URI uri, AdapterData data) throws Exception;
}
