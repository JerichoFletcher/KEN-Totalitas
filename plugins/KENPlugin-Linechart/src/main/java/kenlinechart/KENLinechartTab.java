package kenlinechart;
import ken.backend.controller.holder.InventoryHolder;
import ken.backend.kelas.barang.Barang;
import ken.backend.plugin.AddMenuTab;
import ken.gui.tab.KENTab;

import ken.backend.controller.Controller;
import ken.backend.controller.holder.FixedBillHolder;
import ken.backend.controller.holder.MemberHolder;
import ken.backend.controller.holder.VIPHolder;
import ken.backend.kelas.bill.Bill;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

@AddMenuTab(path = "tabs/linechart")
public class KENLinechartTab extends KENTab{
    @Override
    public String tabName(){
        return "KEN-Linechart";
    }


    public KENLinechartTab() {
        try{
            Controller.instance().fetchData(InventoryHolder.instance(), "barang");
            DefaultCategoryDataset barDataset = new DefaultCategoryDataset();
            for (Map.Entry<Integer, Barang> entry : InventoryHolder.instance().getListBarang().entrySet()) {
                Integer key = entry.getKey();
                Barang barang = entry.getValue();
                barDataset.addValue(barang.getHargaBarang(), "Harga", barang.getNamaBarang());
                barDataset.addValue(barang.getHargaBeliBarang(), "Harga Beli", barang.getNamaBarang());

            }
            JFreeChart chart = ChartFactory.createBarChart(
                    "Bought vs Sell Price Comparison",
                    "Item", "Price", barDataset,
                    PlotOrientation.VERTICAL, true, true, false);

            // set color for the bars
            chart.getCategoryPlot().getRenderer().setSeriesPaint(0, new Color(0, 128, 0));
            chart.getCategoryPlot().getRenderer().setSeriesPaint(1, new Color(255, 0, 0));

            // create panel
            ChartPanel panel = new ChartPanel(chart);
            this.setSize(500,500);
            this.setBackground(new Color(0x2C3333));
            this.setLayout(new BorderLayout());
//            this.setBounds(0,0,500,500);
            this.add(panel, BorderLayout.CENTER);
            this.setLayout(new FlowLayout());
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}

