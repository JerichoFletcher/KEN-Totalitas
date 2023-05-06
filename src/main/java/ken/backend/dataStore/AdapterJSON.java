package ken.backend.dataStore;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ken.backend.kelas.barang.Barang;
import ken.backend.kelas.inventory.Inventory;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AdapterJSON implements AdapterData{
    public <T> T get(URI uri, Class<T> clazz) throws IOException{
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get(uri)));
//        System.out.println(json);
        return gson.fromJson(json, clazz);
    }

    public <T> void write(URI uri, Class<T> clazz) throws IOException{

    }

    //    public Bill[] getFixedBill(){
//
//    }
//    public Bill[] getBill(){
//
//    }
}
