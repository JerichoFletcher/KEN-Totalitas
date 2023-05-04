package ken.gui;

import javax.swing.*;
import java.awt.*;

public class Kasir extends JPanel {
    private JPanel inventory;
    private JPanel cart;
    Kasir(){
        this.setSize(500,500);
        this.setBackground(new Color(0x2C3333));
        this.setLayout(null);
        makePanelKasir();
        this.setBounds(0,0,500,500);
    }

    public void makePanelKasir() {
        JPanel headerInv = new JPanel();
        headerInv.setLayout(null);
        inventory = new JPanel();
        // Set the background and size of the header panel
        inventory.setLayout(null);
        JLabel menuText = new JLabel("Menu");
        menuText.setFont(new Font("Poppins", Font.BOLD,15));
        menuText.setForeground(Color.black);
        headerInv.add(menuText);
        menuText.setBounds(400,0,100,50);
        headerInv.setBackground(new Color(0xD9D9D9));
        headerInv.setBounds(50,50,800, 50);
        inventory.setBackground(new Color(0xFFFFFF));
        inventory.setBounds(50,100,800,500);
        this.add(headerInv);
        this.add(inventory);
        JPanel item1 = new JPanel();
    }

}
