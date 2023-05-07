package ken.backend.controller;

import ken.backend.Vars;
import ken.backend.controller.holder.Holder;
import ken.backend.controller.holder.InventoryHolder;
import ken.backend.dataStore.AdapterData;
import ken.backend.dataStore.AdapterJSON;
import ken.backend.dataStore.AdapterXML;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private static Controller _instance = null;
    public static Controller instance(){
        if(_instance == null){
            _instance = new Controller();
        }
        return _instance;
    }
    @Getter
    @Setter
    private Map<String, AdapterData> adapterList;

    public Controller(){
        this.adapterList = new HashMap<>();
        AdapterData json = new AdapterJSON();
        AdapterData xml = new AdapterXML();
//        AdapterData obj = new AdapterOBJ();
        adapterList.put("json",json);
        adapterList.put("xml",xml);
//        adapterList.put("obj",xml);;

    }

    public void fetchData(Holder obj, String whatData) throws URISyntaxException, IOException {
//        URI uri = URI.create("file://" + "D:/Coding/java/KEN-Totalitas/db");
//        URI uri = URI.create("file://" + "D:/Coding/java/KEN-Totalitas/db");

        obj.load(new File(Vars.path+whatData+"."+Vars.extension).toURI(),adapterList.get(Vars.extension));
    }
    public void writeData(Holder obj, String whatData) throws URISyntaxException, IOException {
        obj.write(new File(Vars.path+whatData+"."+Vars.extension).toURI(),adapterList.get(Vars.extension));
    }


}
