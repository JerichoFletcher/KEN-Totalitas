package kencurrency;

import ken.backend.controller.holder.Holder;
import ken.backend.dataStore.AdapterData;

import java.io.IOException;
import java.net.URI;
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

    public float convert(float amount, String from, String to){
        if(!conversions.containsKey(from))throw new IllegalArgumentException(String.format("Unknown currency %s", from));
        if(!conversions.containsKey(to))throw new IllegalArgumentException(String.format("Unknown currency %s", to));

        return amount * conversions.get(to) / conversions.get(from);
    }

    @Override
    public void load(URI uri, AdapterData data) throws IOException{
        _instance = data.get(uri, getClass());
    }

    @Override
    public void write(URI uri, AdapterData data) throws IOException{
        data.write(uri, instance());
    }
}
