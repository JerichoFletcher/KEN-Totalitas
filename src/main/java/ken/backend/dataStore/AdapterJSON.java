package ken.backend.dataStore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AdapterJSON implements AdapterData{
    public <T> T get(URI uri, Class<T> clazz) throws IOException{
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get(uri)));
        System.out.println(json);
//        System.out.println(json);
        return gson.fromJson(json, clazz);
    }

    public <T> void write(URI uri,T obj) throws IOException{
        // Create an instance of Gson
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Convert the InventoryHolder object to a JSON string
        String json = gson.toJson(obj);
        System.out.println(json);

        // Print the JSON string
//        System.out.println(Paths.get(uri).toString());
        try (FileWriter writer = new FileWriter(Paths.get(uri).toString())) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //    public Bill[] getFixedBill(){
//
//    }
//    public Bill[] getBill(){
//
//    }
}
