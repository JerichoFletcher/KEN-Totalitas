package kencurrency;

import ken.backend.Vars;
import ken.backend.controller.Controller;
import ken.backend.controller.holder.Holder;
import ken.backend.dataStore.AdapterData;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class KENCurrencyHolder implements Holder{
    private static KENCurrencyHolder _instance = null;

    public static KENCurrencyHolder instance(){
        if(_instance == null)_instance = new KENCurrencyHolder();
        return _instance;
    }

    private Map<String, Float> conversions = new HashMap<>();

    private KENCurrencyHolder(){}

    public Map<String, Float> getConversions(){
        return conversions;
    }

    public void loadConfig() throws Exception{
        _instance = Controller.instance().getAdapterList().get(Vars.extension).get(
            KENCurrencyConverter.class.getResource("/kencurrency/converter." + Vars.extension).toURI(),
            KENCurrencyHolder.class
        );
    }

    public float convert(float amount, String from, String to){
        if(!conversions.containsKey(from))throw new IllegalArgumentException(String.format("Unknown currency %s", from));
        if(!conversions.containsKey(to))throw new IllegalArgumentException(String.format("Unknown currency %s", to));

        return amount * conversions.get(to) / conversions.get(from);
    }

    @Override
    public void load(URI uri, AdapterData data) throws Exception{
        _instance = data.get(uri, getClass());
    }

    @Override
    public void write(URI uri, AdapterData data) throws Exception{
        data.write(uri, instance());
    }
}
