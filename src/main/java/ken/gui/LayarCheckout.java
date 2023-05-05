package ken.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LayarCheckout extends JPanel implements ActionListener{
    private JPanel panelBarang;
    private JButton fixBill;
    private JComboBox pilihMember;
    LayarCheckout(){
        super();
        this.setVisible(true);
        this.setBackground(new Color(0x2C3333));
        this.setLayout(null);
        makePanelLC();
        this.setBounds(0,0,500,500);
    }

    public void makePanelLC(){
        JLabel checkoutText = new JLabel("Checkout");
        JLabel totalPrice = new JLabel("Total: Rp." + 1000);
        checkoutText.setFont(new Font("Poppins", Font.BOLD,40));
        checkoutText.setForeground(Color.white);
        checkoutText.setBounds(850,50,500,100);
        totalPrice.setFont(new Font("Poppins", Font.BOLD,30));
        totalPrice.setForeground(Color.white);
        totalPrice.setBounds(600,750,500,100);
        this.add(checkoutText);
        this.add(totalPrice);
        panelBarang = new JPanel();
        panelBarang.setBackground(new Color(0x2C3333));
        panelBarang.setLayout(new BoxLayout(panelBarang, BoxLayout.Y_AXIS));
        panelBarang.setBorder(BorderFactory.createEmptyBorder());
        for (int i = 1; i <= 10; i++) {
            JLabel item = new JLabel("Label " + i);
            item.setForeground(Color.white);
            item.setFont(new Font("Poppins", Font.BOLD,20));
            panelBarang.add(item);
        }
        JScrollPane scrollPane = new JScrollPane(panelBarang);
        scrollPane.setBackground(new Color(0, 0, 0, 0));
        scrollPane.setBounds(600, 150, 700, 600);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        String[] tipeMember = new String[]{"", "jovan", "farhan", "shidqi", "alek", "jericho"};
        pilihMember = new JComboBox(tipeMember);
        pilihMember.setBackground(new Color(0xD9D9D9));
        pilihMember.setBounds(700,850,500,50);
        pilihMember.setFont(new Font("Poppins", Font.BOLD,20));
        pilihMember.setForeground(new Color(0x395B64));
        pilihMember.setFocusable(false);
        this.add(pilihMember);
        this.add(scrollPane);
        fixBill = new JButton();
        fixBill.addActionListener(this);
        fixBill.setFocusable(false);
        fixBill.setContentAreaFilled( false );
        fixBill.setText("FIX BILL");
        fixBill.setFont(new Font("Poppins", Font.BOLD,60));
        fixBill.setBackground(new Color(0, 0, 0, 0));
        fixBill.setForeground(Color.white);
        fixBill.setBorder(BorderFactory.createEmptyBorder());
        fixBill.setBounds(1500,900,400,200);
        this.add(fixBill);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == fixBill){
            System.out.println("tix dummy");
            String selectedItem = (String) pilihMember.getSelectedItem();
            LayarFixedBill layarFB = new LayarFixedBill(selectedItem);
            Tabs.tabs.addCustomTab("Layar Fixed Bill", layarFB, Tabs.tabCount);
            Tabs.tabs.setSelectedComponent(layarFB);
        }
    }
}
