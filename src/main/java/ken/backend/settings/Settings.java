package ken.backend.settings;

import ken.backend.Vars;
import ken.util.UID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Settings{
    private static final Map<UID, SettingsEntry> settingsMap = new HashMap<>();

    public static Object get(UID id){
        SettingsEntry entry = settingsMap.get(id);
        return entry != null ? entry.getStoredValue() : null;
    }

    public static SettingsEntry[] getAllIn(String namespace){
        List<SettingsEntry> entries = new ArrayList<>();
        for(Map.Entry<UID, SettingsEntry> entry : settingsMap.entrySet()){
            if(entry.getKey().getNamespace().equals(namespace))entries.add(entry.getValue());
        }
        return entries.toArray(new SettingsEntry[0]);
    }

    public static void set(UID id, Object value){
        if(settingsMap.containsKey(id)){
            settingsMap.get(id).setStoredValue(value);
        }else throw new IllegalArgumentException(String.format("Unknown settings entry %s", id));
    }

    public static <T> void add(UID id, String name, Class<T> clazz, T initialValue){
        if(settingsMap.containsKey(id)) throw new IllegalArgumentException(String.format("Settings entry %s already exists", id));
        settingsMap.put(id, new SettingsEntry(id, name, initialValue, clazz));
    }

    public static void init(){
        settingsMap.clear();

        // Add builtin settings
        add(UID.of(Vars.defaultNamespace, "settings", "dummy", "number"), "Test number", Integer.class, 7);
        add(UID.of(Vars.defaultNamespace, "settings", "dummy", "text"), "Test string", String.class, "Hello");
        add(UID.of(Vars.defaultNamespace, "settings", "currency"), "Currency", String.class, "IDR");
    }
}
