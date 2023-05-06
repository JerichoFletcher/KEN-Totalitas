package ken.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HistoryPanel extends JPanel implements ActionListener {
    private JButton showDetailBUtton;
    private String judul;
    HistoryPanel(String judul){
        super();
        JLabel title = new JLabel(judul);
        JLabel price = new JLabel("Rp " + 1000);
        this.judul = judul;
        this.setLayout(null);
        this.setBackground(new Color(0xF2F2F2));
        this.setPreferredSize(new Dimension(1000,50));
        this.setMaximumSize(new Dimension(1280,100)); // set maximum size to fixed value
        this.setMinimumSize(new Dimension(1280,100));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        price.setFont(new Font("Poppins", Font.BOLD,20));
        price.setForeground(new Color(0x395B64));
        price.setBorder(BorderFactory.createEmptyBorder());
        price.setBounds(1020,0,100,50);
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
        this.add(price);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == showDetailBUtton) {
            LayarFixedBill layarFB = new LayarFixedBill(judul);
            Tabs.tabs.addCustomTab("Detatil Transaksi", layarFB, Tabs.tabCount);
            Tabs.tabs.setSelectedComponent(layarFB);
        }
    }
}
