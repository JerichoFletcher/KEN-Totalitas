package ken.backend.controller.holder;

import ken.backend.dataStore.AdapterData;
import ken.backend.kelas.anggota.Customer;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement
public class CustomerHolder implements Holder, Serializable {
    private static CustomerHolder _instance = null;
    public static CustomerHolder instance(){
        if(_instance == null){
            _instance = new CustomerHolder();
        }
        return _instance;
    }
    @Getter
    @Setter
    private Map<Integer, Customer> listCustomer;

    private CustomerHolder(){
        this.listCustomer = new HashMap<>();
    }

    public void load(URI uri, AdapterData data) throws IOException, JAXBException {
        _instance = data.get(uri, CustomerHolder.class);
    }

    public void write(URI uri, AdapterData data) throws IOException, JAXBException {
        data.write(uri, CustomerHolder.instance());
    }
    public int getBanyakCustomer(){
        return listCustomer.size();
    }
    public void addCustomer(Customer c) {
        this.listCustomer.put(c.getId(),c);
    }
    public void removeCustomer(int id) {
        this.listCustomer.remove(id);
    }
    public Customer getCustomerById(int id) {
        return listCustomer.get(id);
    }
}
