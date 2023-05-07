package ken.backend.dataStore;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

public class AdapterObject implements AdapterData {

    @Override
    public <T> void write(URI uri, T obj) throws IOException {
        File file = new File(uri);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
        } catch (IOException e) {
            throw new IOException("Failed to write object to file: " + uri, e);
        } finally {
            if (oos != null) {
                oos.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }


    @Override
    public <T> T get(URI uri, Class<T> clazz) throws IOException {
        String path = uri.getPath();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            Object obj = ois.readObject();
            if (clazz.isInstance(obj)) {
                return clazz.cast(obj);
            } else {
                throw new IOException("Object retrieved from file " + path + " is not of type " + clazz.getSimpleName());
            }
        } catch (ClassNotFoundException e) {
            throw new IOException("Class not found while reading object from file: " + path, e);
        } catch (IOException e) {
            throw new IOException("Failed to read object from file: " + path, e);
        }
    }
}