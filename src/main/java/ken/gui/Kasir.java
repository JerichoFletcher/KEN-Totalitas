package ken.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kasir extends JPanel implements ActionListener {
    private JPanel inventory;
    private JPanel cart;
    private JButton addButton;
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
        menuText.setBounds(500,0,100,50);
        headerInv.setBackground(new Color(0xD9D9D9));
        headerInv.setBounds(50,50,1000, 50);
        inventory.setBackground(new Color(0xFFFFFF));
        inventory.setLayout(new BoxLayout(inventory, BoxLayout.Y_AXIS));
        for (int i = 1; i <= 20; i++) {
            MenuItem menuItem = new MenuItem("Barang ke " + i, i);
            inventory.add(menuItem);

        }
        JScrollPane scrollPane = new JScrollPane(inventory);
        scrollPane.setBounds(50, 100, 1000, 920);
        this.add(headerInv);
        this.add(scrollPane);
        JPanel item1 = new JPanel();
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == addButton){
            System.out.println("edit dummy");
        }
    }

}
