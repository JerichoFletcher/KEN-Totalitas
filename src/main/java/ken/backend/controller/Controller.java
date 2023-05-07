package ken.backend.controller;

import ken.backend.controller.holder.InventoryHolder;
import ken.backend.dataStore.AdapterData;
import ken.backend.dataStore.AdapterJSON;
import ken.backend.dataStore.AdapterXML;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
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

    private String path = "/database/";
    private String type = "json";

    public Controller(){
        this.adapterList = new HashMap<>();
        AdapterData json = new AdapterJSON();
        AdapterData xml = new AdapterXML();
//        AdapterData obj = new AdapterOBJ();
        adapterList.put("json",json);
        adapterList.put("xml",xml);
//        adapterList.put("obj",xml);;

    }

    public void fetchData(String whatData) throws URISyntaxException, IOException {
        InventoryHolder.instance().load(getClass().getResource(path+whatData+"."+type).toURI(),adapterList.get(type));
    }
    public void writeData(String whatData) throws URISyntaxException, IOException {
        InventoryHolder.instance().write(getClass().getResource(path+whatData+"."+type).toURI(),adapterList.get(type));
    }


}
