package ken.backend.controller.holder;

import ken.backend.dataStore.AdapterData;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.net.URI;

public interface Holder {
    public void load(URI uri, AdapterData data) throws IOException, JAXBException;
    public void write(URI uri, AdapterData data) throws IOException, JAXBException;
}
