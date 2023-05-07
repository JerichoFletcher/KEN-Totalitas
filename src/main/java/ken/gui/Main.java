package ken.gui;



import ken.backend.plugin.PluginManager;
import ken.util.UID;

import java.nio.file.Paths;
import java.util.jar.JarFile;

public class Main{
    public static void main(String[] args) {
        TabManager.init();
        try{
            PluginManager.init();
//            JarFile jar = new JarFile(Paths.get(Main.class.getResource("/plugins/KENPlugin-Dummy-1.0-SNAPSHOT.jar").toURI()).toString());
//            PluginManager.addFromArchive(jar);
//
//            System.out.println(TabManager.get(UID.of("ken_dummy", "tabs", "dummy")));
        }catch(Exception e){
            e.printStackTrace();
        }

        new LayarUtama();
//        new UnduhHistory();
    }


}
