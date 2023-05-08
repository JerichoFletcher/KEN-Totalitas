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

@AddMenuTab(path = "tabs/piechart")
public class KENPiechartTab extends KENTab{
    @Override
    public String tabName(){
        return "KEN-Piechart";
    }


    public KENPiechartTab() {
        try{
            Controller.instance().fetchData(FixedBillHolder.instance(), "billFixed");
            List<String> listOfNames = new ArrayList<>();
            Map<Integer, Integer> listOfAmount = new HashMap<>();
            for (Map.Entry<Integer, Bill> entry : FixedBillHolder.instance().getListBill().entrySet()) {
                Bill value = entry.getValue();
                Integer id = value.getIdCustomer();
                listOfAmount.merge(id, 1, Integer::sum);
            }
            DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
            for (Map.Entry<Integer, Integer> entry : listOfAmount.entrySet()) {
                Integer key = entry.getKey();
                if(MemberHolder.instance().getMemberById(key) != null){
                    dataset.setValue(MemberHolder.instance().getMemberById(key).getName(), entry.getValue());
                }
                else if(VIPHolder.instance().getVIPById(key) != null){
                    dataset.setValue("VIP " + key , entry.getValue());
                }
            }

            JFreeChart chart = ChartFactory.createPieChart(
                    "Pie Chart Pembelian Member/VIP",  // chart title
                    dataset,                            // data
                    true,                               // include legend
                    true,
                    false
            );

            ChartPanel chartPanel = new ChartPanel(chart);
            this.setSize(500,500);
            this.setBackground(new Color(0x2C3333));
            this.setLayout(new BorderLayout());
//            this.setBounds(0,0,500,500);
            this.add(chartPanel, BorderLayout.CENTER);
//            JLabel label = new JLabel();
//            label.setFont(new Font("Poppins", Font.BOLD, 100));
//            label.setForeground(new Color(0xFFFFFF));
//            label.setBounds(300,100,1000,250);
//            label.setText("Hello dummy");
//            this.add(label);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}

