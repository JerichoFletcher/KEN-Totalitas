package ken.gui;

import ken.backend.Vars;
import ken.gui.tab.*;
import ken.util.UID;
import lombok.Getter;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class TabManager{
    @Getter
    private static final Map<UID, Class<? extends KENTab>> panels = new HashMap<>();

    public static void init(){
        // Unload panel
        panels.clear();

        // Tambahin panel builtin di sini
        panels.put(UID.of(Vars.DEFAULT_NAMESPACE, "kasir"), Kasir.class);
        panels.put(UID.of(Vars.DEFAULT_NAMESPACE, "members"), Members.class);
        panels.put(UID.of(Vars.DEFAULT_NAMESPACE, "inventory"), Inventory.class);
        panels.put(UID.of(Vars.DEFAULT_NAMESPACE, "history"), History.class);
        panels.put(UID.of(Vars.DEFAULT_NAMESPACE, "setting"), Setting.class);
    }

    public static void add(UID id, Class<? extends KENTab> panelClass) throws Exception {
        if(panels.containsKey(id))throw new Exception(String.format("ID already exists: %s", id));
        panels.put(id, panelClass);
    }

    public static Class<? extends KENTab> get(UID id) throws Exception {
        if(!panels.containsKey(id))throw new Exception(String.format("Unknown ID: %s", id));
        return panels.get(id);
    }
}
