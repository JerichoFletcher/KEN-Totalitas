package kenpiechart;

import ken.backend.plugin.Plugin;

public class KENPiechart implements Plugin{
    public static final String NAMESPACE = "ken_piechart";

    @Override
    public String namespace(){
        return NAMESPACE;
    }

    @Override
    public String displayName(){
        return "KEN-Totalitas: Piechart";
    }
}
