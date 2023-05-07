package kenpiechart;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.general.*;
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
