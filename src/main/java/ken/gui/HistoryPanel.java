package ken.gui;

import ken.backend.kelas.barang.Barang;
import ken.backend.kelas.bill.BillItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HistoryPanel extends JPanel implements ActionListener {
    private JButton showDetailBUtton;
    private String judul;
    private JLabel priceLabel;
    private int idBill;
    private int idCust;
    private List<BillItem> listOfBarang;
    private int total;

    public HistoryPanel(int idBill, int idCust, int price, Map<Integer, BillItem> listItemBill){
        super();
        JLabel title = new JLabel("" + idBill + "    " + idCust);
        this.total = price;
        priceLabel = new JLabel("" + price);
        this.listOfBarang = new ArrayList<>(listItemBill.values());
        this.setLayout(null);
        this.setBackground(new Color(0xF2F2F2));
        this.setPreferredSize(new Dimension(1000,50));
        this.setMaximumSize(new Dimension(1280,100)); // set maximum size to fixed value
        this.setMinimumSize(new Dimension(1280,100));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        priceLabel.setFont(new Font("Poppins", Font.BOLD,20));
        priceLabel.setForeground(new Color(0x395B64));
        priceLabel.setBorder(BorderFactory.createEmptyBorder());
        priceLabel.setBounds(1020,0,100,50);
        title.setBounds(10,0,200,50);
        title.setForeground(new Color(0x395B64));
        title.setFont(new Font("Poppins", Font.BOLD,20));
        showDetailBUtton = new JButton("DETIL");
        showDetailBUtton.addActionListener(this);
        showDetailBUtton.setFocusable(false);
        showDetailBUtton.setContentAreaFilled( false );
        showDetailBUtton.setFont(new Font("Poppins", Font.BOLD,20));
        showDetailBUtton.setBackground(new Color(0, 0, 0, 0));
        showDetailBUtton.setForeground(new Color(0x395B64));
        showDetailBUtton.setBorder(BorderFactory.createEmptyBorder());
        showDetailBUtton.setBounds(1120,0,100,50);
        this.add(showDetailBUtton);
        this.add(title);
        this.add(priceLabel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == showDetailBUtton) {
            ShowDetail showDetail = new ShowDetail("" + idCust, listOfBarang, total);
            Tabs.tabs.addCustomTab("Detatil Transaksi", showDetail, Tabs.tabCount);
            Tabs.tabs.setSelectedComponent(showDetail);
        }
    }
}
