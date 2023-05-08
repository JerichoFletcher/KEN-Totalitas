package ken.backend.controller.holder;

import ken.backend.dataStore.AdapterData;
import ken.backend.kelas.barang.*;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement
public class InventoryHolder implements Holder, Serializable {
    private static InventoryHolder _instance = null;
    public static InventoryHolder instance() {
        if (_instance == null) {
            _instance = new InventoryHolder();
        }
        return _instance;
    }
//    @XmlElementWrapper(name = "listBarang")
//    @XmlElement(name = "entry")
    @Getter
    @Setter
    private Map<Integer, Barang> listBarang;

    private InventoryHolder() {
        this.listBarang = new HashMap<>();
    }

    public void load(URI uri, AdapterData data) throws IOException, JAXBException {
        _instance = data.get(uri, InventoryHolder.class);
    }

    public void write(URI uri, AdapterData data) throws IOException, JAXBException {
        data.write(uri, InventoryHolder.instance());
    }

    public int getBanyakBarang() {
        return listBarang.size();
    }

    public void addBarang(Barang b) {
        this.listBarang.put(b.getId(), b);
    }
    public void removeBarang(int id) {
        this.listBarang.remove(id);
    }

    public Barang getBarangById(int id){
        return listBarang.get(id);
    }

//    public void setListBarang(Map <Integer, Barang> listBarang){
//        this.listBarang = listBarang;
//    }
}