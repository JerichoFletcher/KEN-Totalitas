package kenpiechart;
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
import org.jfree.data.general.DefaultPieDataset;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

@AddMenuTab(path = "tabs/linechart")
public class KENLinecharttTab extends KENTab{
    @Override
    public String tabName(){
        return "KEN-Linechart";
    }


    public KENLinechartTab() {
        try{
            Controller.instance().fetchData(InventoryHolder.instance(), "barang");
            List<String> listOfNames = new ArrayList<>();
            Map<Integer, Integer> listOfAmount = new HashMap<>();
            for (Map.Entry<Integer, Bill> entry : FixedBillHolder.instance().getListBill().entrySet()) {
                Bill value = entry.getValue();
                Integer id = value.getIdCustomer();
                listOfAmount.merge(id, 1, Integer::sum);
            }
            // Create a dataset for the line chart

            this.setSize(500,500);
            this.setBackground(new Color(0x2C3333));
            this.setLayout(new FlowLayout());
        }catch (IOException | URISyntaxException ex){
            ex.printStackTrace();
        }

    }
}

