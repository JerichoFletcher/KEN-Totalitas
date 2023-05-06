package ken.gui;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Panels{
    static Map<String, Class<? extends JPanel>> panels = new HashMap<>();

    public static void init(){
        // Unload panel
        panels.clear();

        // Tambahin panel builtin di sini
        panels.put("Kasir", Kasir.class);
//        panels.put("Mem")
    }

    public static void add(String id, Class<? extends JPanel> panelClass) throws Exception {
        if(panels.containsKey(id))throw new Exception(String.format("ID already exists: %s", id));
        panels.put(id, panelClass);

    }

    public static Class<? extends JPanel> get(String id) throws Exception {
        if(!panels.containsKey(id))throw new Exception(String.format("Unknown ID: %s", id));
        return panels.get(id);
    }
}
