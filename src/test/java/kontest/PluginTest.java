package kontest;

import ken.backend.Vars;
import ken.backend.plugin.PluginManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PluginTest{
    @Test
    public void whenInitPluginManager_ShouldHaveBuiltinPlugin(){
        PluginManager.init();
        Assertions.assertNotNull(PluginManager.get(Vars.DEFAULT_NAMESPACE));
    }

    @Test
    public void givenValidPluginJAR_WhenLoadPlugin_ShouldLoadCorrectly(){
        
    }
}
