package kenlinechart;

import ken.backend.plugin.Plugin;

public class KENLinechart implements Plugin{
    public static final String NAMESPACE = "ken_linechart";

    @Override
    public String namespace(){
        return NAMESPACE;
    }

    @Override
    public String displayName(){
        return "KEN-Totalitas: Linechart";
    }
}
