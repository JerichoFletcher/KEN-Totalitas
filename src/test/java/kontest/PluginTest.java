package kontest;

import ken.backend.Vars;
import ken.backend.plugin.PluginManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.jar.JarFile;

public class PluginTest{
    @Test
    public void whenInitPluginManager_ShouldHaveBuiltinPlugin(){
        PluginManager.init();
        Assertions.assertNotNull(PluginManager.get(Vars.DEFAULT_NAMESPACE));
    }

    @Test
    public void givenValidPluginJAR_WhenLoadPlugin_ShouldLoadCorrectly() throws Exception{
        PluginManager.init();
        JarFile jar = new JarFile(Paths.get(getClass().getResource("/plugins/KENPlugin-Dummy-1.0-SNAPSHOT.jar").toURI()).toString());
        PluginManager.addFromArchive(jar);
        Assertions.assertNotNull(PluginManager.get("ken_dummy"));
    }
}
