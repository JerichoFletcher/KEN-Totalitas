package ken.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LayarCheckout extends JPanel {
    private JPanel panelBarang;
    LayarCheckout(){
        super();
        this.setVisible(true);
        this.setBackground(new Color(0xf2f2f2));
        this.setLayout(null);
        makePanelLC();
        this.setBounds(0,0,500,500);
    }

    public void makePanelLC(){
        JLabel checkoutText = new JLabel("Checkout");
        checkoutText.setFont(new Font("Poppins", Font.BOLD,40));
        checkoutText.setForeground(Color.white);
        checkoutText.setBounds(850,50,500,100);
        this.add(checkoutText);
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
        this.add(scrollPane);


    }
}
