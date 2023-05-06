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
    public Inventory getInventory(URI uri) throws IOException {
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get(uri)));
        System.out.println(json);
        Inventory inventory = gson.fromJson(json, Inventory.class);
        return inventory;

    }

    //    public Bill[] getFixedBill(){
//
//    }
//    public Bill[] getBill(){
//
//    }
}
