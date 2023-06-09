package ken.backend.dataStore;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.net.URI;

public interface AdapterData {
    public <T> T get(URI uri, Class<T> clazz) throws Exception;

    public <T> void write(URI uri,T obj) throws Exception;

}
