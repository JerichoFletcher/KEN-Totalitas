package kenpiechart;
import ken.backend.plugin.AddMenuTab;
import ken.gui.tab.KENTab;

import ken.backend.controller.Controller;
import ken.backend.controller.holder.BillHolder;
import ken.backend.controller.holder.FixedBillHolder;
import ken.backend.controller.holder.MemberHolder;
import ken.backend.controller.holder.VIPHolder;
import ken.backend.kelas.anggota.VIP;
import ken.backend.kelas.bill.Bill;
import ken.backend.plugin.AddMenuTab;
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
import javax.swing.*;

@AddMenuTab(path = "tabs/dummy")
public class KenPiechartTab extends KENTab{
    @Override
    public String tabName(){
        return "Dummy";
    }


    public KenPiechartTab() {
        try{
            Controller.instance().fetchData(FixedBillHolder.instance(), "billFixed");
            List<String> listOfNames = new ArrayList<>();
            Map<Integer, Integer> listOfAmount = new HashMap<>();
            for (Map.Entry<Integer, Bill> entry : FixedBillHolder.instance().getListBill().entrySet()) {
                Bill value = entry.getValue();
                Integer id = value.getIdCustomer();
                if(listOfAmount.get(id) != null){
                    listOfAmount.put(id, listOfAmount.get(id) + 1);
                }else{
                    listOfAmount.put(id, 1);
                }
            }
            DefaultPieDataset dataset = new DefaultPieDataset();
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
        }catch (IOException | URISyntaxException ex){
            ex.printStackTrace();
        }

    }
}

