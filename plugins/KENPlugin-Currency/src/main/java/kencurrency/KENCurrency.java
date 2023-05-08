package kencurrency;

import ken.backend.plugin.Plugin;

public class KENCurrency implements Plugin{
    public static final String NAMESPACE = "ken_currency";

    @Override
    public String namespace(){
        return NAMESPACE;
    }

    @Override
    public String displayName(){
        return "KEN-Totalitas: Currency";
    }
}
