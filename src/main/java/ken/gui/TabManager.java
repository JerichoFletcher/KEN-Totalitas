package ken.gui;

import ken.gui.tab.*;
import lombok.Getter;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class TabManager{
    @Getter
    private static final Map<String, Class<? extends KENTab>> panels = new HashMap<>();

    public static void init(){
        // Unload panel
        panels.clear();

        // Tambahin panel builtin di sini
        panels.put("ken:kasir", Kasir.class);
        panels.put("ken:members", Members.class);
        panels.put("ken:inventory", Inventory.class);
        panels.put("ken:history", History.class);
        panels.put("ken:settings", Setting.class);
    }

    public static void add(String id, Class<? extends KENTab> panelClass) throws Exception {
        if(panels.containsKey(id))throw new Exception(String.format("ID already exists: %s", id));
        panels.put(id, panelClass);

    }

    public static Class<? extends KENTab> get(String id) throws Exception {
        if(!panels.containsKey(id))throw new Exception(String.format("Unknown ID: %s", id));
        return panels.get(id);
    }
}
