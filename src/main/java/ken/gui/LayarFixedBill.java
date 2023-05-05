package ken.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LayarFixedBill extends JPanel implements ActionListener {
    private JPanel panelBarang;
    private JButton daftarButton;
    private JButton cetakButton;
    private String customer;
    LayarFixedBill(String customer) {
        super();
        this.customer = customer;
        this.setVisible(true);
        this.setBackground(new Color(0x2C3333));
        this.setLayout(null);
        makePanelLC();
        this.setBounds(0, 0, 500, 500);
    }

    public void makePanelLC() {
        JLabel fixedBill = new JLabel("Fixed Bill");
        JLabel totalPrice = new JLabel("Total: Rp." + 1000);
        fixedBill.setFont(new Font("Poppins", Font.BOLD, 40));
        fixedBill.setForeground(Color.white);
        fixedBill.setBounds(850, 50, 500, 100);
        totalPrice.setFont(new Font("Poppins", Font.BOLD, 30));
        totalPrice.setForeground(Color.white);
        totalPrice.setBounds(600, 750, 500, 100);
        this.add(fixedBill);
        this.add(totalPrice);
        panelBarang = new JPanel();
        panelBarang.setBackground(new Color(0x2C3333));
        panelBarang.setLayout(new BoxLayout(panelBarang, BoxLayout.Y_AXIS));
        panelBarang.setBorder(BorderFactory.createEmptyBorder());
        for (int i = 1; i <= 10; i++) {
            JLabel item = new JLabel("Label " + i);
            item.setForeground(Color.white);
            item.setFont(new Font("Poppins", Font.BOLD, 20));
            panelBarang.add(item);
        }
        JScrollPane scrollPane = new JScrollPane(panelBarang);
        scrollPane.setBackground(new Color(0, 0, 0, 0));
        scrollPane.setBounds(600, 150, 700, 600);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        this.add(scrollPane);
        if (customer.length() == 0) {
            daftarButton = new JButton("Daftar Member/VIP");
            daftarButton.addActionListener(this);
            daftarButton.setBackground(new Color(0xD9D9D9));
            daftarButton.setBounds(700, 850, 500, 50);
            daftarButton.setFont(new Font("Poppins", Font.BOLD, 20));
            daftarButton.setForeground(new Color(0x395B64));
            daftarButton.setFocusable(false);
            this.add(daftarButton);
        }
        else{
            JLabel namaCustomer = new JLabel("Pembelian " + customer + " berhasil di catat");
            namaCustomer.setFont(new Font("Poppins", Font.BOLD, 30));
            namaCustomer.setForeground(Color.white);
            namaCustomer.setBounds(600, 800, 1000, 100);
            this.add(namaCustomer);
        }
        cetakButton = new JButton("Cetak Bill");
        cetakButton.addActionListener(this);
        cetakButton.setBackground(new Color(0xD9D9D9));
        cetakButton.setBounds(700, 930, 500, 50);
        cetakButton.setFont(new Font("Poppins", Font.BOLD, 20));
        cetakButton.setForeground(new Color(0x395B64));
        cetakButton.setFocusable(false);
        this.add(cetakButton);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == daftarButton) {
            DaftarMember layarDM = new DaftarMember();
            Tabs.tabs.addCustomTab("Daftar Member", layarDM, Tabs.tabCount);
            Tabs.tabs.setSelectedComponent(layarDM);
        }
        if(e.getSource() == cetakButton) {
            System.out.println("cetak dummy");
        }
    }
}
