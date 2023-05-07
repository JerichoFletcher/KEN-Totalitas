import ken.backend.plugin.Plugin;

public class KENPluginDummy implements Plugin{
    public static final String NAMESPACE = "ken_dummy";

    @Override
    public String namespace(){
        return NAMESPACE;
    }

    @Override
    public String displayName(){
        return "KEN-Totalitas: Dummy Plugin";
    }
}
